package car.auction.datatransfer;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The Data transfer object for CarHistory
 */
public class CarHistoryDTO {
	private int registerNumber;	// identity
    private String make;
    private String model;
    private String variant;
    private String year;
    
    private int  buyerID;
    private double salesPrice;
	private long salesdate;
	private String pickUpLocation;
	
	public CarHistoryDTO(int registerNumber, String make, String model, String variant ,String year,
			int buyerID, double salesPrice, long salesdate, String pickUpLocation) {
		this.setRegisterNumber(registerNumber);
		this.setMake(make);
		this.setModel(model);
		this.setVariant(variant);
		this.setYear(year);
		this.setYear(year);
		this.setSalesPrice(salesPrice);
		this.setSalesdate(salesdate);
		this.setPickUpLocation(pickUpLocation);
	}
	
	public static void toXML(CarHistoryDTO carHistoryDTO, OutputStream outputStream) {
        XMLEncoder encoder = new XMLEncoder(outputStream);
        encoder.writeObject(carHistoryDTO);
        encoder.close();
    }

    public static CarHistoryDTO fromXML(InputStream inputStream) {
        XMLDecoder decoder = new XMLDecoder(inputStream);
        CarHistoryDTO result = (CarHistoryDTO) decoder.readObject();
        decoder.close();
        return result;
    }

	public int getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(int registerNumber) {
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

	public int getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(int buyerID) {
		this.buyerID = buyerID;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
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

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
}
