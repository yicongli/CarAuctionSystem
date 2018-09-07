package car.auction.domain;

import java.util.List;

import car.auction.datasource.SellerMapper;

public class Seller extends User {
	private String address;
	
	public Seller(int id, String username, String password, String address) {
		super(id, username, password);
		
		this.setAddress(address);
	}
	
	public Seller(String username, String password) {
		super(username, password);
	}

	public String getAddress() {
		if (this.getAddress() == null) {
			address = SellerMapper.getAddressSeller();
		}
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public static Seller getLoginInfoSeller () {
		List<Seller> list= SellerMapper.getLoginInfoSeller();
		return list.isEmpty() ? null : list.get(0);
	}
}
