package db;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.Worksite;

public class DBEmployee implements DBIFEmployee {

	private static final String selectAllQ = 
			//"select name, address, phone, email, position, zipCode, city, ID, wID from employee";
			"Select ID, name, address, zipCode, phone, email, position, wID from employee";
	private static final String selectByIDQ = 
			selectAllQ + " where ID = ?";
	
	//PrepatredStatements
	private PreparedStatement selectAll; 
	private PreparedStatement selectByID;
	
	public DBEmployee() throws SQLException {
		selectAll = DBConnection.getInstance().getConnection()
				.prepareStatement(selectAllQ);
		selectByID = DBConnection.getInstance().getConnection()
				.prepareStatement(selectByIDQ);
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
				//System.out.println(employee.getName());
				System.out.print(employee);
				
			}
	
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find by ID = " + ID);
		}
		
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
				rs.getInt("zipCode"),
				rs.getString("position"),
				rs.getInt("ID"),
				(new Worksite(rs.getInt("wID")))
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
			
			for(Employee employee: res) {
				System.out.println(employee);
			}
		}
		return res;
	}
}
