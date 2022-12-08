package model;

import java.util.Date;

public class RentOrderLine {

	private Date returnDate;
	private Equipment equipment;
	private EDescription eDescription;
	private RentOrder rID;
	
	public RentOrderLine(Date returnDate, Equipment equipment, EDescription eDescription) {
		
		this.returnDate = returnDate;
		this.equipment = equipment;
		this.eDescription = eDescription;
	}
	public RentOrderLine (Date returnDate, Equipment equipment, EDescription eDescription, RentOrder rID) {
		this(returnDate, equipment, eDescription);
		this.rID = rID;
	}

	public String toString() {
		return "Date: " + getReturnDate() + ". Equipment: " + getEquipment();
	}
	
	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * @return the equipment
	 */
	public Equipment getEquipment() {
		return equipment;
	}

	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	/**
	 * @return the eDescription
	 */
	public EDescription geteDescription() {
		return eDescription;
	}

	/**
	 * @param eDescription the eDescription to set
	 */
	public void seteDescription(EDescription eDescription) {
		this.eDescription = eDescription;
	}
	/**
	 * @return the rID
	 */
	public RentOrder getrID() {
		return rID;
	}
	/**
	 * @param rID the rID to set
	 */
	public void setrID(RentOrder rID) {
		this.rID = rID;
	}
	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	

	
}
