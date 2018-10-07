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
    	return CarHistory.getBuyerCarHistories(buyerID);
    }
    
    // get the sold car history for seller
    public List<CarHistory> getSoldCarHistory() {
    	return CarHistory.getSellerCarHistories();
    }
    
    // get all current bidding cars
    public List<BiddingCar> getBiddingCars() {
    	return BiddingCar.getAllAvailableCars();
    }
    
    // update specific cars's bidding price
    public boolean updateBiddingCarPrice (int carID, double biddingPrice, int buyerID) {
    	return BiddingCar.updateBiddingCarPrice(carID, biddingPrice, buyerID);
    }
    
    public boolean deleteBiddingCar (int carID) {
    	return BiddingCar.deleteBiddingCar(carID);
    }
    
    public boolean AddBiddingCar (String registerNumber, String make, String model, String variant, 
			String year, float initialPrice, Long timeLeft) {
    	return BiddingCar.addNewBiddingCar(registerNumber, make, model, variant, year, initialPrice, timeLeft);
    }
    
    public boolean updateBiddingCar (int carID, String registerNumber, String make, String model, String variant, String year) {
    	return BiddingCar.updateBiddingCar(carID, registerNumber, make, model, variant, year);
    }

}
