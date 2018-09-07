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
		Buyer b = BuyerMapper.getUserByUsername(username);
		return (b == null) ? null : new Buyer(b.getId(), b.getUsername(), b.getPassword(), b.getFirstname(),
        		b.getLastname(), b.getPhoneNumber());
	}
	
	public static boolean generateNewBuyer(Buyer buyer) {
		return BuyerMapper.insert(buyer) != -1;
	}
	
    public static List<Buyer> getAllBuyers() {
        List<Buyer> result = new ArrayList<Buyer>();
        List<Buyer> buyerRecords = BuyerMapper.getAllBuyers();

        for (Buyer b : buyerRecords) {
            Buyer buyer = new Buyer(b.getId(), b.getUsername(), b.getPassword(), b.getFirstname(),
            		b.getLastname(), b.getPhoneNumber());
            result.add(buyer);
        }
        return result;
	}
    
    public static void updateBuyer(Buyer buyer) {
    	BuyerMapper mapper = new BuyerMapper();
        Buyer b = BuyerMapper.getUserByID(buyer.getId());
        
        b.setUsername(buyer.getFirstname());
        b.setPassword(buyer.getPassword());
        b.setFirstname(buyer.getFirstname());
        b.setLastname(buyer.getLastname());
        b.setPhoneNumber(buyer.getPhoneNumber());
        
        mapper.update(b);
        
    }
}
