package car.auction.domain;

import java.util.List;

/*
 * This class belong to service layer, mainly manage all the information of users
 * */
public class UserInfoManagementService {

	// singleton
	private static final UserInfoManagementService instance = new UserInfoManagementService();
    
    //private constructor to avoid client applications to use constructor
    private UserInfoManagementService(){}

    public static UserInfoManagementService getInstance(){
        return instance;
    }
	
    /*
     * service provided
     * */
    
	public List<Buyer> getAllBuyers() {
		List<Buyer> buyerInfos = Buyer.getAllBuyers();
		return buyerInfos;
	}
	
	public Buyer getBuyers(String username) {
		Buyer buyer = null;
		return buyer;
	}
	
	public Seller getSeller() {
		// TODO get seller information from Domain
		Seller seller = null;
		return seller;
	}

	/* TODO modify return into boolean to identify if success */
	public boolean generateNewBuyers (String username, String password, 
			String firstname, String lastName, String phoneNumber) {
		Buyer newBuyer = new Buyer(0, username, password, firstname, lastName, phoneNumber);
		// TODO generate insert into domain
		return false;
	}
	
	public boolean deleteBuyer(Integer id) {
		// find buyer through id and send it to the domain 
		// then send delete operation from mapper
		return false;
	}
	
	public boolean updateBuyerInfo(String username, String password, 
			String firstname, String lastName, String phoneNumber) {
		// invoke the update function in buyer 
		return false;
	}
	
	public boolean updateSellerInfo(String username, String password, String address) {
		// invoke the update function in seller
		return false;
	}
}
