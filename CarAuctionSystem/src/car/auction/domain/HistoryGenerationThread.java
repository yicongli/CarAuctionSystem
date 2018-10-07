package car.auction.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import car.auction.datasource.CarHistoryLockingMapper;
import car.auction.datasource.DBConnection;
import car.auction.datasource.BiddingCarLockMapper;

public class HistoryGenerationThread extends Thread {
	
	public void run() {
		
		while (true) {
			long date = System.currentTimeMillis() / 1000;
			
			List<BiddingCar> car = HistoryGenerationThread.getAllCars();
			
			for (BiddingCar biddingCar : car) {
				if (biddingCar.getEndtime() <= date) {
					CarHistory history = new CarHistory(biddingCar);
					CarHistoryLockingMapper.insert(history);
					BiddingCarLockMapper.updatePrice(biddingCar.getId(), biddingCar.getCurrentBid());
				}
			}
			
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static final String getAllCarsStatement = "SELECT * FROM APP.car"
			+ " WHERE price IS NULL";
	
	public static List<BiddingCar> getAllCars(){
		List<BiddingCar> result = new ArrayList<>();
		
		try {
			PreparedStatement stmt = DBConnection.prepare(getAllCarsStatement);
			
			ResultSet rs = stmt.executeQuery();
			DBConnection.dbConnection.commit();
			
			while (rs.next()) {
				BiddingCar car = new BiddingCar (rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getLong(9), rs.getFloat(10));
				
				result.add(car);
			}
			
		} catch (SQLException e) {
			try {
				DBConnection.dbConnection.rollback();
			} catch (SQLException ignored) {
				System.out.println("Rollback failed");
				result = null;
			}
        }
		
		return result;
	}
}
