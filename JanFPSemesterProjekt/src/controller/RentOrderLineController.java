package controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import db.DBRentOrder;
import db.DBRentOrderLine;
import db.DataAccessException;
import model.EDescription;
import model.Employee;
import model.Equipment;
import model.RentOrderLine;
import model.Worksite;

public class RentOrderLineController {

	private DBRentOrderLine dbRentOrderLine;
	
	public RentOrderLineController() throws DataAccessException{
		try {
			dbRentOrderLine = new DBRentOrderLine();
		} catch (SQLException e) {
			throw new DataAccessException(e, "Can't create ProductDB");
		}
	}

	public List<RentOrderLine> findAll() throws DataAccessException {
		return dbRentOrderLine.findAll();
	}
	
	public RentOrderLine findBySerialNumber(int serialNumber) throws DataAccessException {
		return dbRentOrderLine.findBySerialNumber(serialNumber);
	}
	
	public boolean insertRentOrderLine(Date returnDate, Equipment equipment, EDescription eDescription) throws DataAccessException {
		RentOrderLine rentOrderLine = new RentOrderLine(returnDate, equipment, eDescription);
		boolean wasInsertedOK = dbRentOrderLine.insertRentOrderLine(rentOrderLine);
		
		return wasInsertedOK;
	}
	
}
