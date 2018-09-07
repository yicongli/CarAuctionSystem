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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
		UnitOfWork.registerDirty(this);
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
		UnitOfWork.registerDirty(this);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
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
        
    	/*List<Buyer> result = new ArrayList<Buyer>();
        List<Buyer> buyerRecords = BuyerMapper.getAllBuyers();

        for (Buyer b : buyerRecords) {
            Buyer buyer = new Buyer(b.getId(), b.getUsername(), b.getPassword(), b.getFirstname(),
            		b.getLastname(), b.getPhoneNumber());
            result.add(buyer);
        }
        return result;*/
	}
    
    /*public static void main(String [] args)
	{
		for(Buyer b: getAllBuyers()) {
			System.out.println(b.getId()+" "+ b.getUsername() +" "+ b.getPassword() +" "+ b.getFirstname() +" "+ b.getLastname());
		}
    	
    	//System.out.println("user" + getBuyerByUsername("buyer1").getFirstname());
		
	}*/
    
    public static Buyer getBuyer(int id) {
    	Buyer result = null;
    	
    	for (Buyer b : getAllBuyers()) {
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

    	for (Buyer b : getAllBuyers()) {
    		if (b.getUsername().equals(username)) {
	    		Buyer buyer = new Buyer (b.getId(), b.getUsername(), b.getPassword(), b.getFirstname(),
						  b.getLastname(), b.getPhoneNumber());
	    		result = buyer;
    		}
    	}
    	
    	return result;
    }
    
    /*public static void updateBuyer(Buyer buyer) {
        Buyer b = BuyerMapper.getUserByID(buyer.getId());
        
        b.setUsername(buyer.getFirstname());
        b.setPassword(buyer.getPassword());
        b.setFirstname(buyer.getFirstname());
        b.setLastname(buyer.getLastname());
        b.setPhoneNumber(buyer.getPhoneNumber());
        
        BuyerMapper.update(b);
        
    }*/
}
