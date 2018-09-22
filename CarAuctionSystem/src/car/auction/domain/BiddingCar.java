package car.auction.domain;

import java.util.ArrayList;
import java.util.List;

/*
 * Class for Car information
 * */
public class BiddingCar extends Car {
    private float  initialPrice;// initial price
    private float  currentBid;	// current bid price
    private Long   endTime;  	// the ending time of bidding
    private int    curBuyerID;	// the one who has the highest bidding price

    public BiddingCar(int registerNumber, String make, String model, String variant, 
    			String year, float initialPrice, float currentBid, Long endTime) {
    	super(registerNumber, make, model, variant, year);
    	
        this.setInitialPrice(initialPrice);
        this.setCurrentBid(currentBid);
        this.setEndtime(endTime);
    }

	public float getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(float initialPrice) {
		this.initialPrice = initialPrice;
	}

	public float getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(float currentBid) {
		this.currentBid = currentBid;
	}

	public Long getEndtime() {
		return endTime;
	}

	public void setEndtime(Long timeleft) {
		this.endTime = timeleft;
	}

	public int getCurBuyerID() {
		return curBuyerID;
	}

	public void setCurBuyerID(int curBuyerID) {
		this.curBuyerID = curBuyerID;
	}

	public static Car getCar(String registNum) {
    	Car curCar = null;
    	return curCar;
    }

    public static List<Car> getAllAvailableCars() {
        List<Car> result = new ArrayList<Car>();
        return result;
    }

    public static void updateBiddingCar(Car car) {

    }
    
    public static void addNewBiddingCar() {
		// TODO add new car to the db
	}
}
