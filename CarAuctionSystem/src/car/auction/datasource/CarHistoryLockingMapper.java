package car.auction.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

import car.auction.auth.AppSession;
import car.auction.concurrency.LockManager;
import car.auction.domain.CarHistory;

public class CarHistoryLockingMapper implements CarHistoryMapperInterface {

	private CarHistoryMapperInterface impl;
	private LockManager lm;
	private int sessionId;
	
	// Get everything from buyer_car and car table, where the id of buyer_car carID is mapped to the id of car id
	private static final String getAllCarsStatement = "SELECT * FROM APP.buyer_car bc"
			+ " LEFT JOIN APP.car c ON bc.carID = c.id";
	
	// Get everything from buyer_car and car table, where the id of buyer_car carID is mapped to the id of car id, based on buyerID
	private static final String getAllCarsByBuyerIDStatement = "SELECT * FROM APP.buyer_car bc"
			+ " LEFT JOIN APP.car c ON bc.carID = c.id"
			+ " WHERE bc.buyerID = ?";
	
	// Insert values when auction has finished
	private static final String insertStatementString =
            "INSERT INTO APP.buyer_car(carID, buyerID, pickuplocation)" +
            		" VALUES (?, ?, ?)";
	
	// Set the highest currentbid as the price of the car. The price field is used to check if a car has been sold or not
	private static final String updateCarSalesPriceStatementString =
			"UPDATE APP.car"
					+ " SET price = ?"
					+ " WHERE id = ?";
	
	// singleton
	private static final CarHistoryLockingMapper instance = new CarHistoryLockingMapper();

	private CarHistoryLockingMapper() {}
	
	public static CarHistoryLockingMapper getInstance(){
        return instance;
    }

	public CarHistoryLockingMapper(CarHistoryMapperInterface impl) {
		this.impl = impl;
		this.lm = LockManager.getInstance();
		this.sessionId = AppSession.getUser().getId();
	}
	
	@Override
	public List<CarHistory> getAllCars() {
		List<CarHistory> result = new ArrayList<>();
		
		try {
			lm.acquireReadLock(sessionId);
		} catch (InterruptedException e1) {
			System.out.println("Acquiring read lock when adding when getting cars failed");
		}
			
		try {
			PreparedStatement stmt = DBConnection.prepare(getAllCarsStatement);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				CarHistory car = new CarHistory(rs.getInt(4), rs.getInt(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),
						rs.getFloat(11), rs.getLong(12), rs.getInt(1), rs.getString(3));
				
				result.add(car);
			}
			
		} catch (SQLException e) {
			System.out.println("load error: " + e.getMessage());
		}
		
		lm.releaseReadLock(sessionId);
			
		return result;
	}
	
	
	// Get all car history by buyer id
	@Override
	public List<CarHistory> getAllCarsByBuyerId(int id) {
		List<CarHistory> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt = DBConnection.prepare(getAllCarsByBuyerIDStatement);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				CarHistory car = new CarHistory(rs.getInt(4), rs.getInt(5), rs.getString(6),
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),
						rs.getFloat(11), rs.getLong(12), rs.getInt(1), rs.getString(3));
				
				result.add(car);
			}
			
		} catch (SQLException e) {
			System.out.println("load error: " + e.getMessage());
		}
		
		return result;
	}

	// insert when car is sold
	@Override
	public void insert(CarHistory ch) {
		PreparedStatement insertStatement = null;
		
		try {
			insertStatement = DBConnection.prepare(insertStatementString);
			insertStatement.setInt(1, ch.getId());
			insertStatement.setInt(2, ch.getBuyerID());
			insertStatement.setString(3, ch.getPickUpLocation());
			
			insertStatement.executeUpdate();
			
		} catch (SQLException e) {
        	System.out.println("Insert error: " + e.getMessage());
		}
		
	}
	
	// Update car sales price by id
	@Override
	public void updatePrice(int id, float price) {
		PreparedStatement updateStatement = null;
		
		try {
			updateStatement = DBConnection.prepare(updateCarSalesPriceStatementString);
			
			updateStatement.setFloat(1, price);
			updateStatement.setInt(2, id);
			
			updateStatement.execute();
			
		} catch (SQLException e) {
			System.out.println("update error: " + e.getMessage());
		
		}
	}
	
}
