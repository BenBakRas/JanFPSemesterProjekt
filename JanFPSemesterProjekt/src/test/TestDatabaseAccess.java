package test;

import static org.junit.jupiter.api.Assertions.assertEquals;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import org.junit.*;
import java.time.LocalDate;

//import controllayer.ControlPayStation;
//import controllayer.Currency;
//import controllayer.IPayStation;
//import controllayer.IReceipt;
//import controllayer.IllegalCoinException;

import databaselayer.*;
import db.DBConnection;
import model.RentOrder;
import model.RentOrderLine;
import modellayer.*;
import controllayer.*;

//import static org.junit.Assert.*;

public class TestDatabaseAccess {
	
	static DBConnection con = null;
	static RentOrder rentOrder;
	static RentOrderLine rentOrderLine;
	

	/** Fixture for pay station testing. */
	@Before
	public static void setUp() {
		con = DBConnection.getInstance();
	}
	
	
	@Test
	public void wasConnected() {
		//assertNotNull(con, "Connected - connection cannot be null");
		
		DBConnection.closeConnection();
		boolean wasNullified = DBConnection.instanceIsNull();
		assertTrue(wasNullified, "Disconnected - instance set to null");
		
		con = DBConnection.getInstance();
		boolean connectionIsOpen = DBConnection.getOpenStatus();
		assertTrue(connectionIsOpen);	
	}
	
	
	@Test
	public void wasInsertedBuy() throws DatabaseLayerException {
		
		// Arrange
		LocalDate timeNow = java.time.LocalDate.now();
		double payedCentAmount = 100;
		
		 tempPBuy = new PBuy();
		
		PPayStation pStat = new PPayStation(1, "B-423E");
		pStat.setAmount(payedCentAmount);
		tempPBuy.setAssociatedPaystation(pStat);
		tempPBuy.setBuyTime(timeNow);
		
		DatabasePBuy dbPbuy = new DatabasePBuy();
		
		// Act
		int key = dbPbuy.insertParkingBuy(tempPBuy); //TODO: Call dbPbuy
		System.out.println(key);
		
		// Assert
		assertTrue(key>0);
		//int rowsDeleted = dbPbuy.deleteParkingBuy(tempPBuy);
		//assertTrue(rowsDeleted>0);
	}	
	
	
	@Test
	public void wasRetrievedPriceDatabaselayer() throws DatabaseLayerException {
		// Arrange
		PPrice foundPrice;
		int PZoneId = 2;
		DatabasePPrice dbPrice = new DatabasePPrice();
		
		// Act
		foundPrice = dbPrice.getPriceByZoneId(PZoneId);
		// Assert
		assertTrue(foundPrice.getParkingPrice()>0);
		assertEquals(foundPrice.getParkingPrice(), 25, "Den skal være 25");
		System.out.println(foundPrice.getParkingPrice());
	
	}
	
	
	@Test
	public void wasRetrievedPriceControllayer() throws DatabaseLayerException {

		// Arrange
		int foundPrice = 0;
		ControlPrice cp = new ControlPrice();
		int pZoneId = 2;
	
		// Act
		try {
			PPrice karl = cp.getPriceRemote(pZoneId);
			foundPrice = karl.getParkingPrice();
			
		}catch (DatabaseLayerException e){
			System.out.println("virker ikke");
		}
		
		// Assert
		assertTrue(foundPrice > 0);
		System.out.println(foundPrice);
		
	}	
	
	
	/** Fixture for pay station testing. */
	@AfterAll
	public static void cleanUp() {
		DBConnection.closeConnection();
	}	
	
	@AfterClass
	public static void cleanUpWhenFinish() {
		// 		
		// Arrange
		DatabasePBuy dbPbuy = new DatabasePBuy();
		int numDeleted = 0;
		
		// Act
		try {
			numDeleted = dbPbuy.deleteParkingBuy(tempPBuy);
		} catch(Exception ex) { 
			System.out.println("Error: " + ex.getMessage());
		} finally {
			DBConnection.closeConnection();
		}
	
		// Assert
		assertEquals(1, numDeleted, "One row deleted");
	}	

}
