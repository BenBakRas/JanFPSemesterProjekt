package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.DBConnection;
import db.DBRentOrder;
import db.DBRentOrderLine;
import db.DataAccessException;
import model.EDescription;
import model.Employee;
import model.Equipment;
import model.RentOrder;
import model.RentOrderLine;
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
	
	public int insertRentOrder(Date rentDate, Worksite rentedFrom, Worksite rentedTo, Employee empID) throws DataAccessException {
		RentOrder rentOrder = new RentOrder(rentDate, rentedFrom, rentedTo, empID);
		int rID = dbRentOrder.insertRentOrder(rentOrder);
		
		
		return rID;
	}
	
	public void insertRentOrderLine(Date returnDate, Equipment equipment, EDescription eDescription, RentOrder rID) throws DataAccessException, SQLException {
		RentOrderLine rentOrderLine = new RentOrderLine(returnDate, equipment, eDescription, rID);
		
		
		try {
			DBConnection.getInstance();
			DBRentOrder dbRo = new DBRentOrder();
			DBConnection.getInstance().startTransaction();
			dbRo.insertRentOrderLine(rentOrderLine);
			DBConnection.getInstance().commitTransaction();
		}catch(Exception w) {
			DBConnection.getInstance().rollbackTransaction();
		}
		
	}
	
	
	public int deletedFromRentOrder(int rID) throws DataAccessException {
		int deleted = dbRentOrder.deleteFromRentOrder(rID);

		return deleted;
	}
	
	public RentOrder readRentOrder(int rID) throws Exception {
		
		RentOrder foundRentOrder = null;
		ArrayList<RentOrderLine> foundRentOrderLines = new ArrayList<RentOrderLine>();
		
		DBRentOrderLine dbRol = new DBRentOrderLine();
		DBRentOrder dbRo = new DBRentOrder();
		
		try {
			DBConnection.getInstance();
			foundRentOrder = dbRo.findByRID(rID);
			foundRentOrderLines = dbRol.getRentOrderLineFromDBByRID(rID);
			foundRentOrder.setRentOrderLines(foundRentOrderLines);
			
			System.out.println(foundRentOrderLines);
			System.out.println(rID);
			System.out.println(foundRentOrder);
			
		}catch(Exception e) {
			throw new Exception ("RentOrderNotFound");
		}finally {
			DBConnection.getInstance().disconnect();
		}
		
		return foundRentOrder;
	}
	
	/*public int deletedFromRentOrderLine(int serialNumber) throws DataAccessException, SQLException {
		DBRentOrderLine dbRentOrderLine = new DBRentOrderLine();
		int deleted = dbRentOrderLine.deleteFromRentOrderLine(serialNumber);

		return deleted;
	}*/
	
	
}
