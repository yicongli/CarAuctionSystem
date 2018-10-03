package car.auction.remotefacade;

import java.rmi.RemoteException;

import car.auction.datatransfer.BuyerDTO;
import car.auction.domain.UserInfoManagementService;

/**
 * The remote facade for getting and updating buyer information
 */
public class BuyerServiceBean {
	
	// get buyer information from local database and return it to remote request
	public BuyerDTO getBuyer (int id) throws RemoteException {
		return new BuyerDTO(UserInfoManagementService.getInstance().getBuyerById(id));
	}
	
	// get buyer information from local and generate XML String for remote request
	public String getBuyerXml (int id) throws RemoteException {
		BuyerDTO buyer = getBuyer(id);
		return BuyerDTO.jaxbObjectToXML(buyer);
	}
	
	// receive buyerDTO from remote and then update local buyer information
	public void updateBuyer(BuyerDTO buyerDTO) {
		UserInfoManagementService.getInstance().updateBuyerInfo(buyerDTO);
	}

}
