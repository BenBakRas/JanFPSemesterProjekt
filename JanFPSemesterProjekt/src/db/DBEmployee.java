package db;

import java.sql.Connection;
import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.Worksite;

public class DBEmployee implements DBIFEmployee {

	private static final String selectAllQ = 
			"Select ID, name, address, zipCode, phone, email, position, wID from employee";
	private static final String selectByIDQ = 
			selectAllQ + " where ID = ?";
	private static final String insertEmployeeQ =
			"insert into Employee (name, address, zipCode, phone, email, position, wID) values (?,?,?,?,?,?,?) ";
	
	//PrepatredStatements
	private PreparedStatement selectAll; 
	private PreparedStatement selectByID;
	private PreparedStatement insertEmployee;
	
	public DBEmployee() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		selectAll = con.prepareStatement(selectAllQ);
		selectByID = con.prepareStatement(selectByIDQ);
		insertEmployee = con.prepareStatement(insertEmployeeQ);
	}
	
	/*
	 * Returns a list of all employees
	 */
	public List<Employee> findAll() throws DataAccessException  {
		try {
			ResultSet rs = selectAll.executeQuery();
			List<Employee> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Could not find all");
			throw he;
		}
	}
	/*
	 * @param int employeeID
	 * Finds employee by employeeID
	 * @returns Employee
	 */
	public Employee findByID(int ID) throws DataAccessException {
		Employee employee = null;
		try {
			selectByID.setInt(1, ID);
			ResultSet rs = selectByID.executeQuery();
			if(rs.next()) {
				employee = buildObject(rs);
				
				
			}
	
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find by ID = " + ID);
		}
		//System.out.print(employee);
		return employee;
	}
	/*
	 * Builds employee Object
	 */
	private Employee buildObject(ResultSet rs) throws SQLException {
		Employee employee = new Employee(
				rs.getString("name"),
				rs.getString("address"),
				rs.getString("phone"),
				rs.getString("email"),
				rs.getString("zipCode"),
				rs.getString("position"),
				(new Worksite(rs.getInt("wID"))),
				rs.getInt("ID")
				);
		return employee;
	}

	/*
	 * BuildObjects of employee list
	 */
	
	private List<Employee> buildObjects(ResultSet rs) throws SQLException {
		List<Employee> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildObject(rs));
			}
	
			for(Employee employee: res) {
				System.out.println(employee);
			
		}
		return res;
	}

	/*
	 * Inserts a rentOrder into the database
	 */
	
	@Override
	public boolean insertEmployee(Employee employee) throws DataAccessException {
		boolean wasInsertedOK;

		try {
			//"select (name, address, zipCode, phone, email, position, wID) values (?,?,?,?,?,?,?) ";
			
			insertEmployee.setString(1, employee.getName());
			insertEmployee.setString(2, employee.getAddress());
			insertEmployee.setString(3, employee.getZipCode());
			insertEmployee.setString(4, employee.getPhone());
			insertEmployee.setString(5, employee.getEmail());
			insertEmployee.setString(6, employee.getPosition());
			insertEmployee.setInt(7, employee.getwID().getwID());
			int rowsInserted = insertEmployee.executeUpdate();
			wasInsertedOK = (rowsInserted == 1);
			
		} catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Could not insert rows");
			throw he;
		}
		
		return wasInsertedOK;
	}
	
}
