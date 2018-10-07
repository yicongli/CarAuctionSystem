package car.auction.domain;

import java.util.List;

import car.auction.datatransfer.BuyerDTO;

/*
 * This class belong to service layer, mainly manage all the information of users
 * */
public class UserInfoManagementService {

	// singleton
	private static final UserInfoManagementService instance = new UserInfoManagementService();
    
    //private constructor to avoid client applications to use constructor
    private UserInfoManagementService(){
        // start history generation thread when the login page shows
        Thread historyThread = new HistoryGenerationThread();
        historyThread.start();
    }

    public static UserInfoManagementService getInstance(){
        return instance;
    }
	
    /*
     * provided service 
     */
    
    // get all buyers
	public List<Buyer> getAllBuyers() {
		List<Buyer> buyerInfos = Buyer.getAllBuyers();
		return buyerInfos;
	}
	
	// get user information according to the username and its user type
	public User getUser(String username, boolean isSeller) {
		return isSeller ? Seller.getLoginInfoSeller() : Buyer.getBuyerByUsername(username);
	}
	
	// get user information according to the username
	public User getUser(String username) {
		User user = Buyer.getBuyerByUsername(username);
		if (user == null) {
			User seller = Seller.getLoginInfoSeller();
			if (seller.getUsername().equals(username)) {
				user = seller;
			}
		}
		
		return user;
	}
	
	// get buyer by id
	public Buyer getBuyerById(int id) {
		return Buyer.getBuyer(id);
	}

	// generate new buyer and send data to the domain 
	// check if current has already had buyer with same username
	public boolean generateNewBuyers (String username, String password, 
			String firstname, String lastName, String phoneNumber) {
		
		Buyer check = Buyer.getBuyerByUsername(username);
		if (check == null) {
			Buyer.generateNewBuyer(username, password, firstname, lastName, phoneNumber);
			return true;
		}
		else {
			return false;
		}
	}
	
	// delete buyer according to its username
	public void deleteBuyer(String username) {
		Buyer.deleteBuyer(username);
	}
	
	// update buyer information
	public void updateBuyerInfo(int id, String username, String password, 
			String firstname, String lastName, String phoneNumber) {
		Buyer.updateBuyer(id, username, password, firstname, lastName, phoneNumber);
	}
	
	// update buyer information from remote facade
	public void updateBuyerInfo(BuyerDTO buyerDTO) {
		Buyer.updateBuyer(buyerDTO);
	}
	
	// update seller information
	public void updateSellerInfo(String username, String password, String address, Seller seller) {
		Seller.updateSeller(username, password, address, seller);
	}
}
