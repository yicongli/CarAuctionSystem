package car.auction.datasource;

import java.util.List;

import car.auction.domain.CarHistory;

public interface CarHistoryMapperInterface {

	public List<CarHistory> getAllCars (CarHistory ch);
	
	public List<CarHistory> getAllCarsByBuyerId (int id);
	
	public void insert(CarHistory ch);
	
	public void updatePrice(int id, float price);
}
