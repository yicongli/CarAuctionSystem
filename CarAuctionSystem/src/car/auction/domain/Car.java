package car.auction.domain;

import java.util.ArrayList;
import java.util.List;

/*
 * Class for Car information
 * */
public class Car {
	private int registerNumber;	// identity
    private String make;
    private String model;
    private String variant;
    private String year;

    public Car(int registerNumber, String make, String model, String variant, String year) {
        this.setRegisterNumber(registerNumber);
        this.setMake(make);
        this.setModel(model);
        this.setVariant(variant);
        this.setYear(year);
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
