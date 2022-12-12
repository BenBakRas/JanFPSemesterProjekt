package controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import db.DBRentOrder;
import db.DataAccessException;
import model.Employee;
import model.RentOrder;
import model.Worksite;


public class RentOrderController {

	private DBRentOrder dbRentOrder;
	
	public RentOrderController() throws DataAccessException {
		try {
			dbRentOrder = new DBRentOrder();
		} catch (SQLException e) {
			throw new DataAccessException(e, "Can't create ProductDB");
		}
	}
	
	public List<RentOrder> findAll() throws DataAccessException {
		return dbRentOrder.findAll();
	}
	
	public RentOrder findByRID(int rID) throws DataAccessException {
		return dbRentOrder.findByRID(rID);
	}
	
	public boolean insertRentOrder(Date rentDate, Worksite rentedFrom, Worksite rentedTo, Employee empID) throws DataAccessException {
		RentOrder rentOrder = new RentOrder(rentDate, rentedFrom, rentedTo, empID);
		boolean wasInsertedOK = dbRentOrder.insertRentOrder(rentOrder);
		
		return wasInsertedOK;
	}
	
	
}
