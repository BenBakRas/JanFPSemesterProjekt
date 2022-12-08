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
import model.RentOrder;
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
	
	public RentOrderLine findByRID(int rID) throws DataAccessException {
		return dbRentOrderLine.findByRID(rID);
	}
	
	public boolean insertRentOrderLine(Date returnDate, Equipment equipment, EDescription eDescription, RentOrder rID) throws DataAccessException {
		RentOrderLine rentOrderLine = new RentOrderLine(returnDate, equipment, eDescription, rID);
		boolean wasInsertedOK = dbRentOrderLine.insertRentOrderLine(rentOrderLine);
		
		return wasInsertedOK;
	}
	
}
