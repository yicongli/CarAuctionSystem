package car.auction.domain;

public class BoughtCar extends Car {
	private double price;
	private long purchaseDate;
	private int sellerID;
	private String pickUpLocation;
	
	public BoughtCar(int rgNo, String make, String model, String variant, String year, double price,
			long purchaseDate, int sellerID, String pickUpLocation ) {
		super(rgNo, make, model, variant, year);
		
		this.setPrice(price);
		this.setPurchaseDate(purchaseDate);
		this.setSellerID(sellerID);
		this.setPickUpLocation(pickUpLocation);
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public long getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(long purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

}
