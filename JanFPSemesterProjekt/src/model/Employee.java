package model;

public class Employee {

	private String name;
	private String address;
	private String phone;
	private String email;
	private int zipCode;
	private String city;
	private String position;
	private int ID;
	private Worksite worksite;
	
	public Employee(String name, String address, String phone, String email, int zipCode, String position, int ID, Worksite worksite) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.position = position;
		this.zipCode = zipCode;
		this.city = city;
		this.ID = ID;
		this.worksite = worksite;
		
	}
	
	public Employee(int ID) {
		
	}
		
	@Override
	public String toString() {
		return "Name: " + getName()+ ". Phone: " + getPhone() + ". Address: " + getAddress() + ". ID: " + getEmployeeID();
	}
	
	
	
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the employeeID
	 */
	public int getEmployeeID() {
		return ID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(int ID) {
		this.ID = ID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the wID
	 */
	public Worksite getwID() {
		return worksite;
	}
	/**
	 * @param wID the wID to set
	 */
	public void setWorksite(Worksite worksite) {
		this.worksite = worksite;
	}

	

}
