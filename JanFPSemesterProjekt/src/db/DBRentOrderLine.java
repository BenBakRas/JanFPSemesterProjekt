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
	private static final String selectBySerialNumberQ = 
			selectAllQ + " where serialNumber = ?";
	private static final String InsertRentOrderLineQ = 
			"insert into rentOrderLine (rID, serialNumber, eID, returnDate) values (?,?,?,?)";

	
	//PrepatredStatements
	private PreparedStatement selectAll; 
	private PreparedStatement selectBySerialNumber;
	private PreparedStatement InsertRentOrderLine;
	
	public DBRentOrderLine() throws SQLException{
		Connection con = DBConnection.getInstance().getConnection();
		selectAll = con.prepareStatement(selectAllQ);
		selectBySerialNumber = con.prepareStatement(selectBySerialNumberQ);
		InsertRentOrderLine = con.prepareStatement(InsertRentOrderLineQ);
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
	public RentOrderLine findBySerialNumber(int serialNumber) throws DataAccessException {
		RentOrderLine rentOrderLine = null;
		try {
			selectBySerialNumber.setInt(1, serialNumber);
			ResultSet rs = selectBySerialNumber.executeQuery();
			if(rs.next()) {
				rentOrderLine = buildObject(rs);
				//System.out.println(employee.getName());
				System.out.print(rentOrderLine);
				
			}
	
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find by serialNumber = " + serialNumber);
		}
		
		return rentOrderLine;
	}
	/*
	 * Builds equipment Object
	 */
	private RentOrderLine buildObject(ResultSet rs) throws SQLException {
		RentOrderLine rentOrderLine = new RentOrderLine(
				rs.getDate("returnDate"),
				(new Equipment(rs.getInt("eID"))),
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

		try {
			//insert into rentOrderLine (rID, serialNumber, eID, returnDate) values (?,?,?,?)"
			InsertRentOrderLine.setInt(1, rentOrderLine.getrID().getrID());
			InsertRentOrderLine.setInt(2, rentOrderLine.getEquipment().getSerialNumber());
			InsertRentOrderLine.setInt(3, rentOrderLine.geteDescription().geteID());
			int rowsInserted = InsertRentOrderLine.executeUpdate();
			wasInsertedOK = (rowsInserted == 1);
			
		} catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Could not insert rows");
			throw he;
		}
		
		return wasInsertedOK;
	}
}


