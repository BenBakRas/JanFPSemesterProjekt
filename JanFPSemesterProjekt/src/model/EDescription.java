package model;

public class EDescription {

	private String eName;
	private String model;
	private int eID;
	
	
	public EDescription(String eName, String model) {
		
		this.eName = eName;
		this.model = model;
		
	}
	// Reuses constructor with fewer parameters.
	public EDescription(String eName, String model, int eID) {
		
		this(eName, model);
		this.eID = eID;
		
	}
	
	public String toString() {
		return "Equipment Name: " + geteName() + " Model: " + getModel() + " eID: " + geteID();
	}


	public EDescription(int eID) {
		// TODO Auto-generated constructor stub
	}
	


	/**
	 * @return the eName
	 */
	public String geteName() {
		return eName;
	}


	/**
	 * @param eName the eName to set
	 */
	public void seteName(String eName) {
		this.eName = eName;
	}


	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}


	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}


	/**
	 * @return the eID
	 */
	public int geteID() {
		return eID;
	}


	/**
	 * @param eID the eID to set
	 */
	public void seteID(int eID) {
		this.eID = eID;
	}

}
