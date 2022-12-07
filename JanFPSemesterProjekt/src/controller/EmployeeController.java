package controller;

import java.sql.SQLException;
import java.util.List;

import db.DBEmployee;
import db.DBIFEmployee;
import db.DataAccessException;
import model.EDescription;
import model.Employee;
import model.Worksite;

public class EmployeeController {

	private DBEmployee dbEmployee;
	
	public EmployeeController() throws DataAccessException {
		try {
			dbEmployee = new DBEmployee();
		} catch (SQLException e) {
			throw new DataAccessException(e, "Can't create ProductDB");
		}
	}
	

	public List<Employee> findAll() throws DataAccessException {
		return dbEmployee.findAll();
	}
	
	public Employee findByEID(int ID) throws DataAccessException {
		return dbEmployee.findByID(ID);
	}
	
	public boolean insertEmployee(String name, String address, String phone, String email, String zipCode, String position, Worksite wID) throws DataAccessException {
		Employee employee = new Employee(name, address, phone, email,zipCode, position, wID);
		boolean wasInsertedOK = dbEmployee.insertEmployee(employee);
		
		return wasInsertedOK;
		}
		
}
	

