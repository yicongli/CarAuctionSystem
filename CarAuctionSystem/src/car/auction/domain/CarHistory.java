package car.auction.domain;

public class CarHistory extends Car {
	
	private double salesPrice;
	private long salesdate;
	private String pickUpLocation;
	private int buyerID;

	public CarHistory(int registerNumber, String make, String model, String variant, 
    			String year, double salesPrice, long salesdate, int buyerID) {
    	super(registerNumber, make, model, variant, year);
    	
        this.setSalesPrice(salesPrice);
        this.setSalesdate(salesdate);
        this.setBuyerID(buyerID);
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public long getSalesdate() {
		return salesdate;
	}

	public void setSalesdate(long salesdate) {
		this.salesdate = salesdate;
	}

	public int getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(int buyerID) {
		this.buyerID = buyerID;
	}
	
	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public String getBuyerName () {
		Buyer buyer = UserInfoManagementService.getInstance().getBuyerById(this.buyerID);
		return buyer.getFullName();
	}

}
