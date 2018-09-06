package car.auction.domain;

public class Seller extends User {
	private String address;
	
	public Seller(int id, String username, String password, String address) {
		super(id, username, password);
		
		this.setAddress(address);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
