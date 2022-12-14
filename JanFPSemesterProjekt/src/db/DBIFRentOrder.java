package db;

import java.util.List;

import model.RentOrder;


public interface DBIFRentOrder {

	List<RentOrder> findAll() throws DataAccessException;
	RentOrder findByRID(int rID) throws DataAccessException;
	int insertRentOrder(RentOrder rentOrder) throws DataAccessException;
	int deleteFromRentOrder(int rID)throws DataAccessException;
	

}
