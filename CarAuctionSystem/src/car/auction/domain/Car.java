package car.auction.domain;

import java.util.ArrayList;
import java.util.List;

/*
 * Class for Car information
 * */
public class Car {
	private int id;
	private int sellerId;
	private String registerNumber;
    private String make;
    private String model;
    private String variant;
    private int year;

    public Car(int id, int sellerId, String registerNumber, String make, String model, String variant, int year) {
    	this.setId(id);
    	this.setSellerId(sellerId);
        this.setRegisterNumber(registerNumber);
        this.setMake(make);
        this.setModel(model);
        this.setVariant(variant);
        this.setYear(year);
    }
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
    
    public int getSellerId(int sellerId) {
    	return sellerId;
    }
    
    public void setSellerId(int sellerId) {
    	this.sellerId = sellerId;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
