package car.auction.datatransfer;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import car.auction.domain.CarHistory;

/**
 * This class is the CarHistoryDTO holder which will be used to transfer list of CarHistoryDTO
 */
public class CarHistoryListDTO
{
    private List<CarHistoryDTO> list = null;
    
    public CarHistoryListDTO(List<CarHistory> histories) {
		this.list = generateList(histories);
	}
 
    public List<CarHistoryDTO> getList() {
        return list;
    }
 
    public void setList(List<CarHistoryDTO> historyList) {
        this.list = historyList;
    }
    
    // generate DTO from the list of CarHistory
    public ArrayList<CarHistoryDTO> generateList (List<CarHistory> histories) {
    	ArrayList<CarHistoryDTO> tempList = new ArrayList<>();
    	for (CarHistory carHistory : histories) {
			CarHistoryDTO newHistoryDTO = new CarHistoryDTO(carHistory);
			tempList.add(newHistoryDTO);
		}
    	
    	return tempList;
    }
    
    // Convert CarHistoryList to XML String
 	public static String jaxbObjectToXML(CarHistoryListDTO list) {
 	    String xmlString = "";
 	    try {
 	        JAXBContext context = JAXBContext.newInstance(CarHistoryListDTO.class);
 	        Marshaller m = context.createMarshaller();

 	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 

 	        StringWriter sw = new StringWriter();
 	        m.marshal(list, sw);
 	        xmlString = sw.toString();

 	    } catch (JAXBException e) {
 	        e.printStackTrace();
 	    }

 	    return xmlString;
 	}
}
