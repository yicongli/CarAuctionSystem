package car.auction.datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import car.auction.domain.Buyer;

public class UnitOfWork extends TimerTask{
	
	private static List<Buyer> newBuyer = new ArrayList<Buyer>();
	private static List<Buyer> dirtyBuyer = new ArrayList<Buyer>();
	private static List<Buyer> deletedBuyer = new ArrayList<Buyer>();
	private static List<Buyer> cleanBuyer = new ArrayList<Buyer>();


	public static void registerNew(Buyer buyer) {
		if (!newBuyer.contains(buyer) && !dirtyBuyer.contains(buyer)) {
			newBuyer.add(buyer);
			System.out.println("Add New :"+ buyer.getId());
		}
	}
	
	public static void registerDirty(Buyer buyer) {
		if (!dirtyBuyer.contains(buyer) && !newBuyer.contains(buyer)) {
			cleanBuyer.remove(buyer);
			dirtyBuyer.add(buyer);
			System.out.println("Add dirty :"+ buyer.getId());
		}
	}
	
	public static void registerDeleted(Buyer buyer) {
		if (newBuyer.remove(buyer)) return;
		dirtyBuyer.remove(buyer);
		
		if (!deletedBuyer.contains(buyer)) {
			deletedBuyer.add(buyer);
			cleanBuyer.remove(buyer);
		}
		
		System.out.println("Add delete :"+ buyer.getId());
		
	}
	
	public static void registerClean(Buyer buyer) {
		cleanBuyer.add(buyer);
		System.out.println("Add clean :"+ buyer.getId());
	}
	
	// Gather all lists into one
	public static List<Buyer> allBuyersList() {
		List<Buyer> allBuyers = new ArrayList<Buyer>();
		
		allBuyers.addAll(newBuyer);
		allBuyers.addAll(dirtyBuyer);
		allBuyers.addAll(cleanBuyer);
		
		System.out.println("load memory info");
		
		return allBuyers;
	}
	
	
	// commit the lists and then empty them
	public void commit() {
						
		for (Buyer buyer : newBuyer) {
			BuyerMapper.insert(buyer);
		}
		
		for (Buyer buyer : dirtyBuyer) {
			BuyerMapper.update(buyer);
		}
		
		for (Buyer buyer : deletedBuyer) {
			BuyerMapper.delete(buyer);
		}
		
		newBuyer = new ArrayList<>();
		dirtyBuyer = new ArrayList<>();
		deletedBuyer = new ArrayList<>();
		
		Buyer.hasExecutedOnce = true;
		cleanBuyer = Buyer.getAllBuyers();

	}

	@Override
	public void run() {
		commit();
		System.out.println("Committed to the DB");
	}
	
}
