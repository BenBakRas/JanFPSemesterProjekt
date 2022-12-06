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
	
	
	
	public RentOrder(int rID, Date rentDate) {
		this.rID = rID;
		this.rentDate = rentDate;
		rentOrderLines = new ArrayList<>();
	}

	
	public RentOrderLine createOrderLine(Equipment eq, EDescription eDesc, Date returnDate){
		RentOrderLine rentOrderLine = new RentOrderLine(eq, eDesc,returnDate);
		rentOrderLines.add(rentOrderLine);
        return rentOrderLine;
    }
    
   
    
    public RentOrderLine addProductToOrder(Equipment eq, EDescription eDesc, Date returnDate){
        if(rentOrderLines.size() != 0){
            for(RentOrderLine rentOrderLine : rentOrderLines){
                if(rentOrderLine.getEquipment().equals(eq)){
                	returnDate = new Date();
                	eDesc = rentOrderLine.geteDescription();
                   
                	rentOrderLine.seteDescription(eDesc);
                    return rentOrderLine;
                } else {
                    return createOrderLine(eq, eDesc, returnDate);
                }
            }
        }
        else {
        	return createOrderLine(eq, eDesc, returnDate);
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
    }
	
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
