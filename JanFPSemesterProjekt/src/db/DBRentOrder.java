package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RentOrder;

public class DBRentOrder {

	private static final String selectAllQ = 
			"select rID, rentedFrom, rentedTo, rentDate, employeeID";
	private static final String selectByRIDQ = 
			selectAllQ + " where rID = ?";
	
	//PrepatredStatements
	private PreparedStatement selectAll; 
	private PreparedStatement selectByRID;
	
	
	public DBRentOrder()throws SQLException{
		selectAll = DBConnection.getInstance().getConnection()
				.prepareStatement(selectAllQ);
		selectByRID = DBConnection.getInstance().getConnection()
				.prepareStatement(selectByRIDQ);
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
				System.out.print("");
				
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
				rs.getInt("rID"),
				rs.getDate("returnDate")
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
	
	
	
}
