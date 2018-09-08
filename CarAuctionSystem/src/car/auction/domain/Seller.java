package car.auction.domain;

import java.util.List;

import car.auction.datasource.SellerMapper;

/*
 * Class for Seller information
 * */
public class Seller extends User {
	private String address;
	
	public Seller(int id, String username, String password, String address) {
		super(id, username, password);
		
		this.setAddress(address);
	}
	
	public Seller(String username, String password) {
		super(username, password);
	}
	
	//Lazy load, get address when needed
	public String getAddress() {
		if (this.address == null) {
			address = SellerMapper.getAddressSeller();
		}
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	//Get only necessary info to login
	public static Seller getLoginInfoSeller () {
		List<Seller> list= SellerMapper.getLoginInfoSeller();
		return list.isEmpty() ? null : list.get(0);
	}
	
	// update seller info
	public static void updateSeller(String username, String password, String address, Seller seller) {
		seller.setUsername(username);
		seller.setPassword(password);
		seller.setAddress(address);
		
		SellerMapper.update(seller);
	}
}
