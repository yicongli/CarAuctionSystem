package car.auction.domain;

public class AuctionManagementService {

	// singleton
	private static final AuctionManagementService instance = new AuctionManagementService();
    
    //private constructor to avoid client applications to use constructor
    private AuctionManagementService(){}

    public static AuctionManagementService getInstance(){
        return instance;
    }

}
