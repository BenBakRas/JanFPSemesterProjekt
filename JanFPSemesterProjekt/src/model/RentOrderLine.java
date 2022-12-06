package model;

import java.util.Date;

public class RentOrderLine {

	private Date returnDate;
	private Equipment equipment;
	private EDescription eDescription;
	
	public RentOrderLine(Equipment equipment, EDescription eDescription, Date returnDate) {
		
		this.returnDate = returnDate;
		this.equipment = equipment;
		this.eDescription = eDescription;
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

	
}
