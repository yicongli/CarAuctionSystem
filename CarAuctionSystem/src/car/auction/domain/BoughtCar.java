package car.auction.domain;

public class BoughtCar extends Car {
	private double price;
	private long purchaseDate;
	private String pickUpLocation;
	
	public BoughtCar(int rgNo, String make, String model, String variant, String year, double price,
			long purchaseDate, String pickUpLocation ) {
		super(rgNo, make, model, variant, year);
		
		this.setPrice(price);
		this.setPurchaseDate(purchaseDate);
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

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

}
