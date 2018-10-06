package car.auction.domain;

import java.util.List;

import car.auction.datasource.CarHistoryLockingMapper;
import car.auction.datasource.CarMapper;

public class HistoryGenerationThread extends Thread {
	
	public void run() {
		
		CarHistoryLockingMapper maper = CarHistoryLockingMapper.getInstance();
		
		while (true) {
			long date = System.currentTimeMillis() / 1000;
			
			List<BiddingCar> car = CarMapper.getAllCars();
			
			for (BiddingCar biddingCar : car) {
				if (biddingCar.getEndtime() <= date) {
					CarHistory history = new CarHistory(biddingCar);
					maper.insert(history);
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
