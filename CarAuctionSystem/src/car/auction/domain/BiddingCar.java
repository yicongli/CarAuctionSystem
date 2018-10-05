package car.auction.domain;

import java.util.ArrayList;
import java.util.List;

/*
 * Class for Car information
 * */
public class BiddingCar extends Car {
    private float  currentBid;	// current bid price
    private Long   endTime;  	// the ending time of bidding
    private int    curBuyerID;	// the one who has the highest bidding price

    public BiddingCar(int id, int sellerId, String registerNumber, String make, String model, String variant, 
    			int year, Long endTime, float currentBid) {
    	super(id, sellerId, registerNumber, make, model, variant, year);
    	
        this.setCurrentBid(currentBid);
        this.setEndtime(endTime);
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
