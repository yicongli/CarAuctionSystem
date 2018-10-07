package car.auction.domain;

import java.util.List;

import car.auction.datasource.BiddingCarLockMapper;

/*
 * Class for Car information
 * */
public class BiddingCar extends Car {
    private float  currentBid;	// current bid price
    private long   endTime;  	// the ending time of bidding
    private int    curBuyerID;	// the one who has the highest bidding price

    public BiddingCar(int id, int curBuyerID, String registerNumber, String make, String model, String variant, 
    			int year, long endTime, float currentBid) {
    	super(id, registerNumber, make, model, variant, year);
    	
        this.setCurrentBid(currentBid);
        this.setEndtime(endTime);
        this.setCurBuyerID(curBuyerID);
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

    public static List<BiddingCar> getAllAvailableCars() {
        List<BiddingCar> result = BiddingCarLockMapper.getInstance().getAllCars();
        return result;
    }

    public static boolean updateBiddingCarPrice(int carID, double biddingPrice, int buyerID) {
    	return BiddingCarLockMapper.getInstance().updateBid((float)biddingPrice, carID, buyerID);
    }
    
    public static boolean updateBiddingCar(int carID, String registerNumber, String make, 
    		String model, String variant, String year) {
    	BiddingCar car = BiddingCarLockMapper.getInstance().getCarById(carID);
    	car.setRegisterNumber(registerNumber);
    	car.setMake(make);
    	car.setModel(model);
    	car.setVariant(variant);
    	car.setYear(Integer.parseInt(year));
    	
    	return BiddingCarLockMapper.getInstance().updateCarInfo(car);
    }
    
    public static boolean deleteBiddingCar(int carID) {
    	return BiddingCarLockMapper.getInstance().delete(carID);
    }
    
    public static boolean addNewBiddingCar(String registerNumber, String make, String model, String variant, 
			String year, float initialPrice, Long timeLeft) {
    	long currentTime = System.currentTimeMillis() / 1000;
    	long endTime = currentTime + timeLeft;
    	int  iYear = Integer.parseInt(year);
    	BiddingCar newCar = new BiddingCar(0, -1, registerNumber, make, model, variant, iYear, endTime, initialPrice);
    	
    	return BiddingCarLockMapper.getInstance().insert(newCar);
	}
}
