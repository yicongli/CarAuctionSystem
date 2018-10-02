package car.auction.dataTransfer;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * The Data transfer object for Buyer information
 */
public class BuyerDTO {
	private int    buyerID;
	private String firstname;	
	private String lastname;
	private String phoneNumber;

	public BuyerDTO(int buyerID, String firstname, String lastname, String phoneNumber) {
		this.buyerID = buyerID;
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setPhoneNumber(phoneNumber);
	}

	public int getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(int buyerID) {
		this.buyerID = buyerID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static void toXML(BuyerDTO buyerDTO, OutputStream outputStream) {
        XMLEncoder encoder = new XMLEncoder(outputStream);
        encoder.writeObject(buyerDTO);
        encoder.close();
    }

    public static BuyerDTO fromXML(InputStream inputStream) {
        XMLDecoder decoder = new XMLDecoder(inputStream);
        BuyerDTO result = (BuyerDTO) decoder.readObject();
        decoder.close();
        return result;
    }
}
