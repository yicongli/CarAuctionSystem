package car.auction.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import car.auction.datasource.CarMapper;

/*
 * Class for Car information
 * */
public class BiddingCar extends Car {
    private float  currentBid;	// current bid price
    private long   endTime;  	// the ending time of bidding
    private int    curBuyerID;	// the one who has the highest bidding price

    public BiddingCar(int id, int sellerId, String registerNumber, String make, String model, String variant, 
    			int year, long endTime, float currentBid) {
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

	public long getEndtime() {
		return endTime;
	}

	public void setEndtime(long timeleft) {
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
        List<BiddingCar> result = CarMapper.getAllCars();
        return result;
    }

    public static boolean updateBiddingCarPrice(int carID, double biddingPrice) {
    	CarMapper.updateBid((float)biddingPrice, carID);
    	return false;
    }
    
    public static boolean updateBiddingCar(int carID, String registerNumber, String make, 
    		String model, String variant, String year) {
    	BiddingCar car = CarMapper.getCarById(carID);
    	car.setRegisterNumber(registerNumber);
    	car.setMake(make);
    	car.setModel(model);
    	car.setVariant(variant);
    	car.setYear(Integer.parseInt(year));
    	
    	CarMapper.updateCarInfo(car);
    	return false;
    }
    
    public static boolean deleteBiddingCar(int carID) {
    	CarMapper.delete(carID);
    	return false;
    }
    
    public static boolean addNewBiddingCar(String registerNumber, String make, String model, String variant, 
			String year, float initialPrice, Long timeLeft) {
    	long currentTime = System.currentTimeMillis();
    	long endTime = currentTime + timeLeft;
    	int  iYear = Integer.parseInt(year);
    	BiddingCar newCar = new BiddingCar(0, 0, registerNumber, make, model, variant, iYear, endTime, initialPrice);
    	CarMapper.insert(newCar);
    	return false;
	}
}
