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
	
	public User getUser(String username, boolean isSeller) {
		return isSeller ? Seller.getSeller() : Buyer.getBuyerByUsername(username);
	}

	// generate new buyer and send data to the domain 
	public boolean generateNewBuyers (String username, String password, 
			String firstname, String lastName, String phoneNumber) {
		Buyer newBuyer = new Buyer(0, username, password, firstname, lastName, phoneNumber);
		return Buyer.generateNewBuyer(newBuyer);
	}
	
	public boolean deleteBuyer(String username) {
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
