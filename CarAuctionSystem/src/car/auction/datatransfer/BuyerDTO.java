package car.auction.datatransfer;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import car.auction.domain.Buyer;

/**
 * The Data transfer object for Buyer information
 */
public class BuyerDTO {
	private int    buyerID;
	private String firstname;	
	private String lastname;
	private String phoneNumber;

	public BuyerDTO(int buyerID, String firstname, String lastname, String phoneNumber) {
		this.setBuyerID(buyerID);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setPhoneNumber(phoneNumber);
	}
	
	public BuyerDTO (Buyer buyer) {
		this.setBuyerID(buyer.getId());
		this.setFirstname(buyer.getFirstname());
		this.setLastname(buyer.getLastname());
		this.setPhoneNumber(buyer.getPhoneNumber());
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

	
	// Write BuyerDTO to outputStream
	public static void toXML(BuyerDTO buyerDTO, OutputStream outputStream) {
        XMLEncoder encoder = new XMLEncoder(outputStream);
        encoder.writeObject(buyerDTO);
        encoder.close();
    }
	
	// Convert BuyerDTO to XML String
	public static String jaxbObjectToXML(BuyerDTO buyer) {
	    String xmlString = "";
	    try {
	        JAXBContext context = JAXBContext.newInstance(BuyerDTO.class);
	        Marshaller m = context.createMarshaller();

	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 

	        StringWriter sw = new StringWriter();
	        m.marshal(buyer, sw);
	        xmlString = sw.toString();

	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }

	    return xmlString;
	}

	// Generate BuyerDTO object from inputStream
    public static BuyerDTO fromXML(InputStream inputStream) {
        XMLDecoder decoder = new XMLDecoder(inputStream);
        BuyerDTO result = (BuyerDTO) decoder.readObject();
        decoder.close();
        return result;
    }
}
