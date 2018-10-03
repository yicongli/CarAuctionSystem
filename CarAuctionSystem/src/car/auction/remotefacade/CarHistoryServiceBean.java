package car.auction.remotefacade;

import java.rmi.RemoteException;
import java.util.List;

import car.auction.datatransfer.CarHistoryListDTO;
import car.auction.domain.AuctionManagementService;
import car.auction.domain.CarHistory;

/**
 * The remote facade for getting CarHistory information
 */
public class CarHistoryServiceBean {

	// get car history from local database, convert to DTO and returen to remote request
	public CarHistoryListDTO getCarHistoryByBuyerID (int buyerID) throws RemoteException {
		List<CarHistory> histories = AuctionManagementService.getInstance().getBoughtCarHistoryByBuyerID(buyerID);
		return new CarHistoryListDTO(histories);
	}
	
	// get car history, generate XML String for remote request
	public String getCarHistoryListXml (int id) throws RemoteException {
		CarHistoryListDTO list = getCarHistoryByBuyerID(id);
		return CarHistoryListDTO.jaxbObjectToXML(list);
	}
}
