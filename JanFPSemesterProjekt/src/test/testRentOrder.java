package test;

import org.junit.jupiter.api.BeforeAll;

import controller.RentOrderController;
import db.DataAccessException;
import model.Employee;
import model.Worksite;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import org.junit.*;


public class testRentOrder {

	
	private static RentOrderController roc;
	
	//@BeforeAll
	public testRentOrder() throws DataAccessException {
		roc = new RentOrderController();
	}

	@Test
	public void shouldCreateRentOrder() throws DataAccessException {
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
	    //int ExistingRID;
	    int lowestPoissibleStartPoint = 1000;
	    
	    //Arrange
	    
	    Worksite karlWorksAt = new Worksite("Kærvanghus","6000",2002);
	    Worksite rentedFrom = new Worksite ("Solvang","9000",2001);
	    Worksite rentedTo = new Worksite("Kærvanghus","6000",2002);
		Employee empID = new Employee ("Karl", "Krævanghus", "9000", "50551378", "Karl@gmail.com", "Worker", karlWorksAt, 102);
		//Act
		int wasInserted = roc.insertRentOrder(sqlDate, rentedFrom, rentedTo, empID);
		
		//Assert
		assertTrue("If the returned value is above 1000 ",wasInserted>lowestPoissibleStartPoint);
		System.out.println(wasInserted);
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
