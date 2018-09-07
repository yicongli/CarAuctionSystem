package car.auction.domain;

import java.util.ArrayList;
import java.util.List;

import car.auction.datasource.BuyerMapper;

public class Buyer extends User {
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

	public static Buyer getBuyer(String username) {
		return BuyerMapper.getUserByUsername(username);
	}
	
	public static boolean generateNewBuyer(Buyer buyer) {
		return BuyerMapper.insert(buyer) != -1;
	}
	
    public static List<Buyer> getAllBuyers() {
        return BuyerMapper.getAllBuyers();
	}
    
    public static void updateBuyer(Buyer buyer) {
        Buyer b = BuyerMapper.getUserByID(buyer.getId());
        
        b.setUsername(buyer.getFirstname());
        b.setPassword(buyer.getPassword());
        b.setFirstname(buyer.getFirstname());
        b.setLastname(buyer.getLastname());
        b.setPhoneNumber(buyer.getPhoneNumber());
        
        BuyerMapper.update(buyer);
        
    }
}
