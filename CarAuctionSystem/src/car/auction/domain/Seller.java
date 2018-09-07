package car.auction.domain;

import java.util.List;

import car.auction.datasource.SellerMapper;

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

	public static Seller getSeller () {
		List<Seller> list= SellerMapper.getSeller();
		return list.isEmpty() ? null : list.get(0);
	}
}
