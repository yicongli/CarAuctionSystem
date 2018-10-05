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
    public List<CarHistory> getBoughtCarHistoryByBuyerID (int buyerID) {
    	return null;
    }
    
    // get the sold car history for seller
    public List<CarHistory> getSoldCarHistory() {
    	return null;
    }
    
    // get all current bidding cars
    public List<BiddingCar> getBiddingCars() {
    	return null;
    }
    
    // update specific cars's bidding price
    public boolean updateBiddingCarPrice (String registerNumber, double biddingPrice) {
    	
    	return false;
    }
    
    public boolean deleteBiddingCar (int carID) {
    	return false;
    }
    
    public boolean AddBiddingCar (String registerNumber, String make, String model, String variant, 
			String year, float initialPrice, Long timeLeft) {
    	return false;
    }
    
    public boolean updateBiddingCar (String registerNumber, String make, String model, String variant, String year) {
    	return false;
    }

}
