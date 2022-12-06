package controller;

import java.sql.SQLException;
import java.util.List;

import db.DBEmployee;
import db.DBIFEmployee;
import db.DataAccessException;

import model.Employee;

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
	
	
}
