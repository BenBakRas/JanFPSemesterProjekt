package model;

import java.util.ArrayList;

public class Worksite {

	private int wID;
	private String wAddress;
	private int zipCode;
	
	
	public Worksite(int wID, String wAddress, int zipCode) {
		
		this.wID = wID;
		this.wAddress = wAddress;
		this.zipCode = zipCode;
		
	}

	public Worksite(int wID) {
		
	}

	public String toString() {
		return "Worksite ID: " + getwID() + ". Address: " + getwAddress() + ". Zipcode: " + getZipCode();
	}
	
	/**
	 * @return the wsAddress
	 */
	public String getwAddress() {
		return wAddress;
	}

	/**
	 * @param wsAddress the wsAddress to set
	 */
	public void setwAddress(String wAddress) {
		this.wAddress = wAddress;
	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}



	/**
	 * @return the wID
	 */
	public int getwID() {
		return wID;
	}



	/**
	 * @param wID the wID to set
	 */
	public void setwID(int wID) {
		this.wID = wID;
	}
}
