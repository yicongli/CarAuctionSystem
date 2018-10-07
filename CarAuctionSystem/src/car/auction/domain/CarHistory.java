package car.auction.domain;

import java.util.List;

import car.auction.datasource.CarHistoryLockingMapper;

public class CarHistory extends Car {
	
	private double salesprice;
	private Long salesdate;
	private String pickuplocation;
	private int buyerID;

	public CarHistory(int id, String registerNumber, String make, String model, String variant, 
    			int year, double salesprice, Long salesdate, int buyerID, String pickuplocation) {
    	super(id, registerNumber, make, model, variant, year);
    	
        this.setSalesdate(salesdate);
        this.setBuyerID(buyerID);
        this.setPickUpLocation(pickuplocation);
	}
	
	public CarHistory (BiddingCar car) {
		super(car.getId(), car.getRegisterNumber(), car.getMake(), car.getModel(), car.getVariant(), car.getYear());
		
		this.setSalesdate(car.getEndtime());
		this.setBuyerID(car.getCurBuyerID());
		this.setPickUpLocation(Seller.getLoginInfoSeller().getAddress());
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
	
	public static List<CarHistory> getBuyerCarHistories (int buyerID) {
		return CarHistoryLockingMapper.getInstance().getAllCarsByBuyerId(buyerID);
	}
	
	public static List<CarHistory> getSellerCarHistories () {
		return CarHistoryLockingMapper.getInstance().getAllCars();
	}

}
