package model;

public class Equipment {

	private int serialNumber;
	private String eState;
	private EDescription description;
	
	public Equipment(int serialNumber, String eState, EDescription description) {
		this.serialNumber = serialNumber;
		this.eState = eState;
		this.description = description;
	}

	
	public Equipment(int serialNumber) {
		
	}
	
	public String toString() {
		return "SerialNumber: " + getSerialNumber() + ". State: " + geteState() + ". Description: " + getDescription();
	}
	
	
	/**
	 * @return the eName
	 */
	public int getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param eName the eName to set
	 */
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the eState
	 */
	public String geteState() {
		return eState;
	}

	/**
	 * @param eState the eState to set
	 */
	public void seteState(String eState) {
		this.eState = eState;
	}

	/**
	 * @return the description
	 */
	public EDescription getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(EDescription description) {
		this.description = description;
	}

}
