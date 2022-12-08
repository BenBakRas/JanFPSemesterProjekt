package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.RentOrder;
import model.Worksite;

public class DBRentOrder implements DBIFRentOrder{

	private static final String selectAllQ = 
			"select rID, rentedFrom, rentedTo, rentDate, empID from RentOrder";
	private static final String selectByRIDQ = 
			selectAllQ + " where rID = ?";
	private static final String insertRentOrderQ =
			"insert into RentOrder(rentDate, rentedFrom, rentedTo, empID) values (?,?,?,?)";
	
	//PrepatredStatements
	private PreparedStatement selectAll; 
	private PreparedStatement selectByRID;
	private PreparedStatement insertRentOrder;
	
	
	public DBRentOrder()throws SQLException{
		Connection con = DBConnection.getInstance().getConnection();
		selectAll = con.prepareStatement(selectAllQ);
		selectByRID = con.prepareStatement(selectByRIDQ);
		insertRentOrder = con.prepareStatement(insertRentOrderQ);
	}

	/*
	 * Returns a list of all EDescription
	 */
	public List<RentOrder> findAll() throws DataAccessException  {
		try {
			ResultSet rs = selectAll.executeQuery();
			List<RentOrder> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Could not find all");
			throw he;
		}
	}
	/*
	 * @param int rID
	 * Finds RentOrder by rID
	 * @returns RentOrder
	 */
	public RentOrder findByRID(int rID) throws DataAccessException {
		RentOrder rentOrder = null;
		try {
			selectByRID.setInt(1, rID);
			ResultSet rs = selectByRID.executeQuery();
			if(rs.next()) {
				rentOrder = buildObject(rs);
				//System.out.println(employee.getName());
				System.out.print(rentOrder);
				
			}
	
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find by rID = " + rID);
		}
		
		return rentOrder;
	}
	/*
	 * Builds RentOrder Object
	 */
	private RentOrder buildObject(ResultSet rs) throws SQLException {
		RentOrder rentOrder = new RentOrder(
				rs.getDate("rentDate"),
				rs.getInt("rID"),
				(new Worksite(rs.getInt("rentedFrom"))),
				(new Worksite(rs.getInt("rentedTo"))),
				(new Employee(rs.getInt("empID")))
				);
		return rentOrder;
	}
	
	/*
	 * BuildObjects of RentOrder list
	 */
	
	private List<RentOrder> buildObjects(ResultSet rs) throws SQLException {
		List<RentOrder> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildObject(rs));
			
			for(RentOrder rentOrder: res) {
				System.out.println(rentOrder);
			}
		}
		return res;
	}

	/*
	 * Inserts a rentOrder into the database
	 */
	
	@Override
	public boolean insertRentOrder(RentOrder rentOrder) throws DataAccessException {
		boolean wasInsertedOK;
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		try {
			
			//"insert into RentOrder(rentDate, rentedFrom, rentedTo, empID) values (?,?,?,?)";
			insertRentOrder.setDate(1, sqlDate);
			insertRentOrder.setInt(2, rentOrder.getRentedFrom().getwID());
			insertRentOrder.setInt(3, rentOrder.getRentedTo().getwID());
			insertRentOrder.setInt(4, rentOrder.getEmpID().getID());
			int rowsInserted = insertRentOrder.executeUpdate();
			wasInsertedOK = (rowsInserted == 1);
			
		} catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Could not insert rows");
			throw he;
		}
		
		return wasInsertedOK;
	}
	
}
