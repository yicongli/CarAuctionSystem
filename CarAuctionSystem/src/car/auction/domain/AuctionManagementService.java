package car.auction.domain;

import java.util.List;

public class AuctionManagementService {

	// singleton
	private static final AuctionManagementService instance = new AuctionManagementService();
    
    //private constructor to avoid client applications to use constructor
    private AuctionManagementService(){}

    public static AuctionManagementService getInstance(){
        return instance;
    }
    
    // get the bought car history of specific buyer
    public List<Car> getBoughtCarHistoryByBuyerID (int buyerID) {
    	return null;
    }
    
    // get the sold car history for seller
    public List<Car> getSoldCarHistory() {
    	return null;
    }
    
    // get all current bidding cars
    public List<BiddingCar> getBiddingCars() {
    	return null;
    }
    
    // update specific cars's bidding price
    public boolean updateBiddingCarPrice (int registerNumber, double biddingPrice) {
    	return false;
    }

}
