package car.auction.datasource;

import java.util.HashMap;
import java.util.Map;

import car.auction.domain.Buyer;

public class Registry {
	private static Map<Integer, Buyer> buyer = new HashMap<>();

	public static Buyer getBuyer(int id) {
        return buyer.get(id);
	}
	
	public static void addBuyer(Buyer buyer) {
        Registry.buyer.put(buyer.getId(), buyer);
    }


}
