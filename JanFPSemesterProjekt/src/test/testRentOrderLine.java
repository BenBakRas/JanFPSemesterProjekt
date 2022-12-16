package test;

import controller.RentOrderController;
import controller.RentOrderLineController;
import db.DataAccessException;
import model.EDescription;
import model.Employee;
import model.Equipment;
import model.RentOrder;
import model.Worksite;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import org.junit.*;


public class testRentOrderLine {

	private static RentOrderLineController rolc;

	
	
	public testRentOrderLine() throws DataAccessException {
		
		rolc = new RentOrderLineController();
		
	}

	
	
	public void shouldCreateROL() throws DataAccessException {
		
		
		//Arrange
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    EDescription eDesc = new EDescription("E202", "spade", 6);
	   
		Equipment equipment = new Equipment(73, "god", eDesc);
		
		Worksite karlWorksAt = new Worksite("Kærvanghus","6000",2002);
	    Worksite rentedFrom = new Worksite ("Solvang","900",2001);
	    Worksite rentedTo = new Worksite("Kærvanghus","6000",2002);
		Employee empID = new Employee ("Karl", "Krævanghus", "9000", "50551378", "Karl@gmail.com", "Worker", karlWorksAt, 102);
		
		boolean verify = true;
		
		//Act
		RentOrder rentOrder = new RentOrder(sqlDate, rentedFrom, rentedTo, empID);
		boolean wasInserted = rolc.insertRentOrderLine(sqlDate, equipment, eDesc, rentOrder);
		
		
		//Assert
		assertEquals(verify, wasInserted);
	}
	
}
