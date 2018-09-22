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
    
    public List<Car> getBoughtCarHistoryByBuyerID (int buyerID) {
    	return null;
    }
    
    public List<Car> getSoldCarHistory() {
    	return null;
    }

}
