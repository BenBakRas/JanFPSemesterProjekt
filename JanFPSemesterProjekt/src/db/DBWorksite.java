package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Worksite;

public class DBWorksite implements DBIFWorksite {

	private static final String selectAllQ = 
			"select wAddress, zipCode, wID from worksite";
	private static final String selectByWIDQ = 
			selectAllQ + " where wID = ?";
	private static final String insertWorksiteQ =
			"insert into Worksite (wAddress, zipCode) values (?,?)";
			
	
	//PrepatredStatements
	private PreparedStatement selectAll;
	private PreparedStatement selectByWID;
	private PreparedStatement insertWorksite;
	
	public DBWorksite()throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		selectAll = con.prepareStatement(selectAllQ);
		selectByWID  = con.prepareStatement(selectByWIDQ);
		insertWorksite = con.prepareStatement(insertWorksiteQ);
	}
	
	
	/*
	 * Returns a list of all Worksites
	 */
	public List<Worksite> findAll() throws DataAccessException  {
		try {
			ResultSet rs = selectAll.executeQuery();
			List<Worksite> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Could not find all");
			throw he;
		}
	}
	/*
	 * @param int wID
	 * Finds EDescription by wID
	 * @returns Worksite
	 */
	public Worksite findByWID(int wID) throws DataAccessException {
		Worksite worksite = null;
		try {
			selectByWID.setInt(1, wID);
			ResultSet rs = selectByWID.executeQuery();
			if(rs.next()) {
				worksite = buildObject(rs);
				//System.out.println(employee.getName());
				System.out.print(worksite);
				
			}
	
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find by wID = " + wID);
		}
		
		return worksite;
	}
	/*
	 * Builds Worksite Object
	 */
	private Worksite buildObject(ResultSet rs) throws SQLException {
		Worksite worksite = new Worksite(
				rs.getString("wAddress"),
				rs.getString("zipCode"),
				rs.getInt("wID")
				);
		
		
		return worksite;
	}
	
	/*
	 * BuildObjects of worksite list
	 */
	
	private List<Worksite> buildObjects(ResultSet rs) throws SQLException {
		List<Worksite> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildObject(rs));
			
			for(Worksite worksite: res) {
				System.out.println(worksite);
			}
		}
		return res;
	}


	@Override
	public boolean insertWorksite(Worksite worksite) throws DataAccessException {
		boolean wasInsertedOK;

		try {
			insertWorksite.setString(1, worksite.getwAddress());
			insertWorksite.setString(2, worksite.getZipCode());
			int rowsInserted = insertWorksite.executeUpdate();
			wasInsertedOK = (rowsInserted == 1);
			
		} catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Could not insert rows");
			throw he;
		}
		
		return wasInsertedOK;
	}
		
}
	


