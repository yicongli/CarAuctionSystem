package car.auction.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;

import car.auction.datasource.BuyerMapper;
import car.auction.datasource.UnitOfWork;

public class Buyer extends User {
	
	private static boolean hasExecutedOnce = true;
	
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public static void generateNewBuyer(String username, String password, 
			String firstname, String lastName, String phoneNumber) {
		Buyer newBuyer = new Buyer(0, username, password, firstname, lastName, phoneNumber);
		UnitOfWork.registerNew(newBuyer);
	}
	
	
    public static List<Buyer> getAllBuyers() {
    	
    	List<Buyer> buyers = new ArrayList<>();
    	
    	if (UnitOfWork.allBuyersList().isEmpty()) {
    		buyers = BuyerMapper.getAllBuyers();
    		System.out.println("load from DB");
    	} else {
    		buyers = UnitOfWork.allBuyersList();
    		System.out.println("load from memory");
    	}
    	
    	return buyers;
	}
      
    public static Buyer getBuyer(int id) {
    	
    	List<Buyer> list = getAllBuyers();
    	for (Buyer b : list) {
    		if (b.getId() == id) {
	    		return b;
    		}
    	}
    	
    	return null;
	}
    
    
    public static void hasLoaded() {
    	if(hasExecutedOnce == true) {
    		BuyerMapper.getAllBuyers();
    		
    		//Commit changes to database every 6000 seconds
    		Timer timer = new Timer();
    		timer.schedule(new UnitOfWork(), 0, 60000);
    		hasExecutedOnce = false;
    	}
    }
    
    public static Buyer getBuyerByUsername(String username) {
    	hasLoaded();
    	
    	List<Buyer> list = getAllBuyers();
    	for (Buyer b : list) {
    		if (b.getUsername().equals(username)) {
	    		return b;
    		}
    	}
    	
    	return null;
    }
    
    public static void updateBuyer(int id, String username, String password, String firstname, 
			String lastname, String phoneNumber) {
    	Buyer updateBuyer = Buyer.getBuyer(id);
    	updateBuyer.setFirstname(firstname);
    	updateBuyer.setLastname(lastname);
    	updateBuyer.setPhoneNumber(phoneNumber);
    	updateBuyer.setPassword(password);
    	updateBuyer.setUsername(username);
    	
    	UnitOfWork.registerDirty(updateBuyer);
	}
    
    public static void deleteBuyer(String username) {
    	Buyer buyer = Buyer.getBuyerByUsername(username);
		UnitOfWork.registerDeleted(buyer);
	}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(this.getId(), buyer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
