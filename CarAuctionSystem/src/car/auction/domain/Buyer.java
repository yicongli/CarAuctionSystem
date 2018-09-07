package car.auction.domain;

import java.util.ArrayList;
import java.util.List;

import car.auction.datasource.BuyerMapper;
import car.auction.datasource.UnitOfWork;

public class Buyer extends User {
	
	private static boolean hasExecutedOnce = false;
	
	private String firstname;
	private String lastname;
	private String phoneNumber;
	
	public Buyer(int id, String username, String password, String firstname, 
			String lastName, String phoneNumber) {
		super(id, username, password);
		
		this.setFirstname(firstname);
		this.setLastname(lastName);
		this.setPhoneNumber(phoneNumber);
	}
	
	public void updatePassword(String password) {
		super.setPassword(password);
		UnitOfWork.registerDirty(this);
	}
	
	public void updateUsername(String username) {
		super.setUsername(username);
		UnitOfWork.registerDirty(this);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void updateFirstname(String firstname) {
		this.firstname = firstname;
		UnitOfWork.registerDirty(this);
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void updateLastname(String lastname) {
		this.lastname = lastname;
		UnitOfWork.registerDirty(this);
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void updatePhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		UnitOfWork.registerDirty(this);
	}
	
	public static boolean generateNewBuyer(Buyer buyer) {
		UnitOfWork.registerNew(buyer);
		return true;
	}
	
	/*public static boolean generateNewBuyer(Buyer buyer) {
		return BuyerMapper.insert(buyer) != -1;
	}*/
	
	// If list is empty, then get the data from database, else get it from memory
    public static List<Buyer> getAllBuyers() {
    	
    	List<Buyer> buyers = new ArrayList<>();
    	
    	if (UnitOfWork.allBuyersList().isEmpty()) {
    		buyers = BuyerMapper.getAllBuyers();
    		System.out.println("path1");
    	} else {
    		buyers = UnitOfWork.allBuyersList();
    		System.out.println("path2");
    	}
    	
    	return buyers;
	}
      
    public static Buyer getBuyer(int id) {
    	Buyer result = null;
    	
    	List<Buyer> list = getAllBuyers();
    	for (Buyer b : list) {
    		if (b.getId() == id) {
	    		Buyer buyer = new Buyer (b.getId(), b.getUsername(), b.getPassword(), b.getFirstname(),
						  b.getLastname(), b.getPhoneNumber());
	    		result = buyer;
    		}
    	}
    	
    	return result;
	}
    
    
    public static void hasLoaded() {
    	if(hasExecutedOnce == true) {
    		BuyerMapper.getAllBuyers();
    		hasExecutedOnce = false;
    	}
    }
    
    public static Buyer getBuyerByUsername(String username) {
    	Buyer result = null;
    	hasExecutedOnce = true;
    	
    	hasLoaded();
    	
    	List<Buyer> list = getAllBuyers();
    	for (Buyer b : list) {
    		if (b.getUsername().equals(username)) {
	    		Buyer buyer = new Buyer (b.getId(), b.getUsername(), b.getPassword(), b.getFirstname(),
						  b.getLastname(), b.getPhoneNumber());
	    		result = buyer;
    		}
    	}
    	
    	return result;
    }
    
    public static void updateBuyer(String username, String password, String firstname, 
			String lastname, String phoneNumber, Buyer updateBuyer) {
    	updateBuyer.updateFirstname(firstname);
    	updateBuyer.updateLastname(lastname);
    	updateBuyer.updatePhoneNumber(phoneNumber);
    	updateBuyer.updatePassword(password);
    	updateBuyer.updateUsername(username);
	}
    
    public static void deleteBuyer(String username) {
    	Buyer buyer = Buyer.getBuyerByUsername(username);
		UnitOfWork.registerDeleted(buyer);
	}
    
}
