package model;

import java.util.ArrayList;
import java.util.Date;

public class RentOrder {

	private int rID;
	private Worksite rentedFrom;
	private Worksite rentedTo;
	private Date rentDate;
	private Employee empID;
	private ArrayList<RentOrderLine> rentOrderLines;
	
	
	
	public RentOrder(Date rentDate, Worksite rentedFrom, Worksite rentedTo, Employee empID) {
		this.rentDate = rentDate;
		this.rentedFrom = rentedFrom;
		this.rentedTo = rentedTo;
		this.empID = empID;
		
	}
	
	//Reuses constructor with fewer parameters.
	public RentOrder(Date rentDate, int rID, Worksite rentedFrom, Worksite rentedTo, Employee empID) {
		this(rentDate, rentedFrom, rentedTo, empID);
		this.rID = rID;
	}
	public RentOrder(int rID) {
		
	}
	
	public String toString() {
		return "RentDate: " + getRentDate() + ". rID: " + getrID();
	}

	/*
	public RentOrderLine createOrderLine(Date returnDate, Equipment eq, EDescription eDesc){
		RentOrderLine rentOrderLine = new RentOrderLine(returnDate, eq, eDesc);
		rentOrderLines.add(rentOrderLine);
        return rentOrderLine;
    }
    
   
    
    public RentOrderLine addProductToOrder(Date returnDate, Equipment eq, EDescription eDesc){
        if(rentOrderLines.size() != 0){
            for(RentOrderLine rentOrderLine : rentOrderLines){
                if(rentOrderLine.getEquipment().equals(eq)){
                	returnDate = new Date();
                	eDesc = rentOrderLine.geteDescription();
                   
                	rentOrderLine.seteDescription(eDesc);
                    return rentOrderLine;
                } else {
                    return createOrderLine(returnDate, eq, eDesc);
                }
            }
        }
        else {
        	return createOrderLine(returnDate, eq, eDesc);
        }
        return null;
    }
    
    public void addOrderLine(RentOrderLine rentOrderLine) {
        rentOrderLines.add(rentOrderLine);
    }
	
	
	public ArrayList<RentOrderLine> getOrderLines() {
        return new ArrayList<>(rentOrderLines);
    }
    
    public void clear() {
    	rentOrderLines.clear(); 
    }*/
	
	/**
	 * @return the rID
	 */
	public int getrID() {
		return rID;
	}

	/**
	 * @param rID the rID to set
	 */
	public void setrID(int rID) {
		this.rID = rID;
	}




	/**
	 * @return the rentedFrom
	 */
	public Worksite getRentedFrom() {
		return rentedFrom;
	}




	/**
	 * @param rentedFrom the rentedFrom to set
	 */
	public void setRentedFrom(Worksite rentedFrom) {
		this.rentedFrom = rentedFrom;
	}




	/**
	 * @return the rentedTo
	 */
	public Worksite getRentedTo() {
		return rentedTo;
	}




	/**
	 * @param rentedTo the rentedTo to set
	 */
	public void setRentedTo(Worksite rentedTo) {
		this.rentedTo = rentedTo;
	}




	/**
	 * @return the rentDate
	 */
	public Date getRentDate() {
		return rentDate;
	}




	/**
	 * @param rentDate the rentDate to set
	 */
	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}




	/**
	 * @return the empID
	 */
	public Employee getEmpID() {
		return empID;
	}




	/**
	 * @param empID the empID to set
	 */
	public void setEmpID(Employee empID) {
		this.empID = empID;
	}

}
