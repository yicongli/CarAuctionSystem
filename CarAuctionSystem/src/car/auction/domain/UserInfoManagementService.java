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
		return isSeller ? Seller.getLoginInfoSeller() : Buyer.getBuyerByUsername(username);
	}
	
	public Buyer getBuyerById(int id) {
		return Buyer.getBuyer(id);
	}

	// generate new buyer and send data to the domain 
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
	
	public void deleteBuyer(String username) {
		Buyer.deleteBuyer(username);
	}
	
	public void updateBuyerInfo(int id, String username, String password, 
			String firstname, String lastName, String phoneNumber) {
		Buyer.updateBuyer(id, username, password, firstname, lastName, phoneNumber);
	}
	
	public void updateSellerInfo(String username, String password, String address, Seller seller) {
		Seller.updateSeller(username, password, address, seller);
	}
}
