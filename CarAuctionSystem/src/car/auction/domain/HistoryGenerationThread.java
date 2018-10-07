package car.auction.domain;

import java.util.List;

import car.auction.datasource.CarHistoryLockingMapper;
import car.auction.datasource.BiddingCarLockMapper;

public class HistoryGenerationThread extends Thread {
	
	public void run() {
		
		CarHistoryLockingMapper historyMaper = CarHistoryLockingMapper.getInstance();
		BiddingCarLockMapper biddingCarLockMapper = BiddingCarLockMapper.getInstance();
		
		while (true) {
			long date = System.currentTimeMillis() / 1000;
			
			List<BiddingCar> car = BiddingCarLockMapper.getInstance().getAllCars();
			
			for (BiddingCar biddingCar : car) {
				if (biddingCar.getEndtime() <= date) {
					CarHistory history = new CarHistory(biddingCar);
					historyMaper.insert(history);
					biddingCarLockMapper.updatePrice(biddingCar.getId(), biddingCar.getCurrentBid());
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
