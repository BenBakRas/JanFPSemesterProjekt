package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EDescription;
import model.Equipment;
import model.RentOrder;
import model.RentOrderLine;

public class DBRentOrderLine {

	private static final String selectAllQ = 
			"select rID, serialNumber, eID, returnDate from rentOrderLine";
	private static final String selectByRIDQ = 
			selectAllQ + " where rID = ?";
	private static final String insertRentOrderLineQ = 
			"insert into rentOrderLine (returnDate, serialNumber, eID, rID) values (?,?,?,?)";
	private static final String deleteFromRentOrderLineQ =
			"delete from RentOrderline where serialNumber = ?";

	
	//PrepatredStatements
	private PreparedStatement selectAll; 
	private PreparedStatement selectByRID;
	private PreparedStatement InsertRentOrderLine;
	private PreparedStatement deleteFromRentOrderLine;
	
	public DBRentOrderLine() throws SQLException{
		Connection con = DBConnection.getInstance().getConnection();
		selectAll = con.prepareStatement(selectAllQ);
		selectByRID = con.prepareStatement(selectByRIDQ);
		InsertRentOrderLine = con.prepareStatement(insertRentOrderLineQ);
		deleteFromRentOrderLine = con.prepareStatement(deleteFromRentOrderLineQ);
	}
	
	
	/*
	 * Returns a list of all equipment
	 */
	public List<RentOrderLine> findAll() throws DataAccessException  {
		try {
			ResultSet rs = selectAll.executeQuery();
			List<RentOrderLine> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Could not find all");
			throw he;
		}
	}
	/*
	 * @param int serialNumber
	 * Finds employee by serialNumber
	 * @returns equipment
	 */
	public RentOrderLine findByRID(int rID) throws DataAccessException {
		RentOrderLine rentOrderLine = null;
		try {
			selectByRID.setInt(1, rID);
			ResultSet rs = selectByRID.executeQuery();
			if(rs.next()) {
				rentOrderLine = buildObject(rs);
				//System.out.println(employee.getName());
				//System.out.print(rentOrderLine);
				
			}
	
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find by serialNumber = " + rID);
		}
		
		return rentOrderLine;
	}
	/*
	 * Builds equipment Object
	 */
	private RentOrderLine buildObject(ResultSet rs) throws SQLException {
		RentOrderLine rentOrderLine = new RentOrderLine(
				rs.getDate("returnDate"),
				(new Equipment(rs.getInt("serialNumber"))),
				(new EDescription(rs.getInt("eID"))),
				(new RentOrder(rs.getInt("rID")))
				);
		return rentOrderLine;
	}
	
	/*
	 * BuildObjects of employee list
	 */
	
	private List<RentOrderLine> buildObjects(ResultSet rs) throws SQLException {
		List<RentOrderLine> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildObject(rs));
			
			for(RentOrderLine rentOrderLine: res) {
				System.out.println(rentOrderLine);
			}
		}
		return res;
	}
	
	public boolean insertRentOrderLine(RentOrderLine rentOrderLine) throws DataAccessException {
		
		boolean wasInsertedOK;
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		try {
			//insert into rentOrderLine (rID, serialNumber, eID, returnDate) values (?,?,?,?)"
			InsertRentOrderLine.setDate(1, sqlDate);
			InsertRentOrderLine.setInt(2, rentOrderLine.getEquipment().getSerialNumber());
			InsertRentOrderLine.setInt(3, rentOrderLine.geteDescription().geteID());
			InsertRentOrderLine.setInt(4, rentOrderLine.getrID().getrID());
			int rowsInserted = InsertRentOrderLine.executeUpdate();
			wasInsertedOK = (rowsInserted == 1);
			
		} catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Could not insert rows");
			throw he;
		}
		
		return wasInsertedOK;
	}
	
		public int deleteFromRentOrderLine(int serialNumber)throws DataAccessException {
			int deleted = 0;
			try {
				deleteFromRentOrderLine.setInt(1, serialNumber);
				deleted = deleteFromRentOrderLine.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return deleted;
		}
	

}


