package car.auction.domain;


public class CarHistory extends Car {
	
	private double salesprice;
	private Long salesdate;
	private String pickuplocation;
	private int buyerID;

	public CarHistory(int id, int sellerId, String registerNumber, String make, String model, String variant, 
    			int year, double salesprice, Long salesdate, int buyerID, String pickuplocation) {
    	super(id, sellerId, registerNumber, make, model, variant, year);
    	
        this.setSalesdate(salesdate);
        this.setBuyerID(buyerID);
	}
	
	public double getSalesPrice() {
		return salesprice;
	}
	
	public void setSalesPrice(double salesprice) {
		this.salesprice = salesprice;
	}

	public Long getSalesdate() {
		return salesdate;
	}

	public void setSalesdate(Long salesdate) {
		this.salesdate = salesdate;
	}

	public int getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(int buyerID) {
		this.buyerID = buyerID;
	}
	
	public String getPickUpLocation() {
		return pickuplocation;
	}

	public void setPickUpLocation(String pickuplocation) {
		this.pickuplocation = pickuplocation;
	}

	public String getBuyerName () {
		Buyer buyer = UserInfoManagementService.getInstance().getBuyerById(this.buyerID);
		return buyer.getFullName();
	}

}
