package db;

import java.util.List;

import model.RentOrderLine;

public interface DBIFRentOrderLine {

	List<RentOrderLine> findAll() throws DataAccessException;
	RentOrderLine findByserialNumber(int serialNumber) throws DataAccessException;
	boolean insertWorksite(RentOrderLine rentOrderLine) throws DataAccessException;
	
}
