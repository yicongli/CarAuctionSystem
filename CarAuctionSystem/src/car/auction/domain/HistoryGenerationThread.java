package car.auction.domain;

import java.util.List;

import car.auction.datasource.CarHistoryLockingMapper;
import car.auction.datasource.BiddingCarLockMapper;

public class HistoryGenerationThread extends Thread {
	
	public void run() {
		
		while (true) {
			long date = System.currentTimeMillis() / 1000;
			
			List<BiddingCar> car = BiddingCarLockMapper.getAllCars();
			
			for (BiddingCar biddingCar : car) {
				if (biddingCar.getEndtime() <= date) {
					CarHistory history = new CarHistory(biddingCar);
					CarHistoryLockingMapper.insert(history);
					BiddingCarLockMapper.updatePrice(biddingCar.getId(), biddingCar.getCurrentBid());
				}
			}
			
			try {
				System.out.println("check car 1s later");
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
