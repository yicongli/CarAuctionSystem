package car.auction.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
	private String registerNumber;
    private String make;
    private String model;
    private String variant;
    private String year;
    private float  initialPrice;
    private float  currentBid;
    private Long   endTime;  	// the ending time of bidding
    private int    curBuyerID;	// the one who has the highest bidding price

    public Car(String registerNumber, String make, String model, String variant, 
    			String year, float initialPrice, float currentBid, Long endTime) {
        this.setRegisterNumber(registerNumber);
        this.setMake(make);
        this.setModel(model);
        this.setVariant(variant);
        this.setYear(year);
        this.setInitialPrice(initialPrice);
        this.setCurrentBid(currentBid);
        this.setEndtime(endTime);
    }

    public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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
        //BookFinder finder = new BookFinder();
        //BookGateway br = finder.find(isbn);
//        return (br == null) ? null : new Book(String.valueOf(br.getIsbn()), br.getAuthor(),
//                br.getTitle(), br.getPrice(), br.getCopies());
    	return curCar;
    }

    public static List<Car> getAllAvailableCars() {
//        BookFinder finder = new BookFinder();
        List<Car> result = new ArrayList<Car>();
//        List<BookGateway> booksRecords = finder.findAvailableBooks();
//
//        for (BookGateway br : booksRecords) {
//            Book book = new Book(String.valueOf(br.getIsbn()), br.getAuthor(), br.getTitle(),
//                    br.getPrice(), br.getCopies());
//            result.add(book);
//        }
        return result;
    }

    public static void updateCar(Car car) {
//        BookFinder finder = new BookFinder();
//        BookGateway br = finder.find(book.getIsbn());
//        br.setCopies(book.getCopies());
//        br.setAuthor(book.getAuthor());
//        br.setPrice(book.getPrice());
//        br.setTitle(book.getTitle());
//        br.update();
    }
    
    public static void addNewCar() {
		// TODO add new car to the db
	}
}
