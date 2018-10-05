package car.auction.domain;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

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

    public static List<BiddingCar> getAllAvailableCars() {
        List<BiddingCar> result = new ArrayList<BiddingCar>();
        return result;
    }

    public static boolean updateBiddingCarPrice(int carID, double biddingPrice) {
    	return false;
    }
    
    public static boolean updateBiddingCar(int carID, String registerNumber, String make, 
    		String model, String variant, String year) {
    	return false;
    }
    
    public static boolean deleteBiddingCar(int carID) {
    	return false;
    }
    
    public static boolean addNewBiddingCar(String registerNumber, String make, String model, String variant, 
			String year, float initialPrice, Long timeLeft) {
		return false;
	}
}
