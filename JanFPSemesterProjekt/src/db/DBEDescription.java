package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EDescription;

public class DBEDescription implements DBIFEDescription {

	private static final String selectAllQ = 
			"select eID, eName, model from EDescription";
	private static final String selectByEIDQ = 
			selectAllQ + " where eID = ?";
	
	//PrepatredStatements
	private PreparedStatement selectAll; 
	private PreparedStatement selectByEID;
	
	
	public DBEDescription()throws SQLException {
		selectAll = DBConnection.getInstance().getConnection()
				.prepareStatement(selectAllQ);
		selectByEID = DBConnection.getInstance().getConnection()
				.prepareStatement(selectByEIDQ);
	}

	/*
	 * Returns a list of all EDescription
	 */
	public List<EDescription> findAll() throws DataAccessException  {
		try {
			ResultSet rs = selectAll.executeQuery();
			List<EDescription> res = buildObjects(rs);
			return res;
		} catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Could not find all");
			throw he;
		}
	}
	/*
	 * @param int eID
	 * Finds EDescription by eID
	 * @returns EDescription
	 */
	public EDescription findByEID(int eID) throws DataAccessException {
		EDescription eDescription = null;
		try {
			selectByEID.setInt(1, eID);
			ResultSet rs = selectByEID.executeQuery();
			if(rs.next()) {
				eDescription = buildObject(rs);
				//System.out.println(employee.getName());
				System.out.print(eDescription.geteID() + "\t" + eDescription.geteName() + "\t" + eDescription.getModel());
				
			}
	
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find by eID = " + eID);
		}
		
		return eDescription;
	}
	/*
	 * Builds EDescription Object
	 */
	private EDescription buildObject(ResultSet rs) throws SQLException {
		EDescription eDescription = new EDescription(
				rs.getString("eName"),
				rs.getString("model"),
				rs.getInt("eID")
				);
		return eDescription;
	}
	
	/*
	 * BuildObjects of EDescription list
	 */
	
	private List<EDescription> buildObjects(ResultSet rs) throws SQLException {
		List<EDescription> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildObject(rs));
			
			for(EDescription eDescription: res) {
				System.out.println(eDescription);
			}
		}
		return res;
	}
	
	
}
