package car.auction.datasource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

import car.auction.concurrency.LockManager;

import car.auction.domain.CarHistory;

public class CarHistoryLockingMapper implements CarHistoryMapperInterface {
	
	private CarHistoryMapperInterface impl;
	private LockManager lm;
	private String sessionId;
	
	
	private static final String getAllCarsStatement = "SELECT * FROM APP.buyer_car bc"
			+ " LEFT JOIN APP.car c ON bc.carID = c.id";
	
	private static final String insertStatementString =
            "INSERT INTO APP.buyer_car(carID, buyerID, pickuplocation)" +
            		" VALUES (?, ?, ?)";

	
	
	
	public CarHistoryLockingMapper(CarHistoryMapperInterface impl) {
		this.impl = impl;
		//this.lm = .getInstance();
		//this.sessionId = sessionId;
	}

	@Override
	public List<CarHistory> getAllCars(CarHistory ch) {
		List<CarHistory> result = new ArrayList<>();
		
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
		
		
		return result;
	}

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

}
