package model;


public class Worksite {


	private String wAddress;
	private String zipCode;
	private int wID;
	
	
	public Worksite(String wAddress, String zipCode) {
		
		this.wAddress = wAddress;
		this.zipCode = zipCode;
		
		
	}
	public Worksite (int wID) {
		this.wID = wID;
	}
	public Worksite(String wAddress, String zipCode, int wID) {
		
		this(wAddress,zipCode);
		this.wID = wID;
	}
		
		
	
	
	//Reuses constructor with fewer parameters.
	/*public Worksite (String wAddress, String zipCode, int wID) {
		
		this(wAddress, zipCode);
		this.wID = wID;
	}*/

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
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
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
