package db;

import java.sql.Connection;



import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EDescription;
import model.Equipment;

public class DBEquipment implements DBIFEquipment{

	
	private static final String selectAllQ = 
			"select serialNumber, eState, eID from Equipment";
	private static final String selectBySerialNumberQ = 
			selectAllQ + " where serialNumber = ?";
	private static final String InsertEquipmentQ = 
			"insert into equipment (serialNumber, eState, eID) values (?,?,?)";

	
	//PrepatredStatements
	private PreparedStatement selectAll; 
	private PreparedStatement selectBySerialNumber;
	private PreparedStatement InsertEquipment;
	
	public DBEquipment()throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		selectAll = con.prepareStatement(selectAllQ);
		selectBySerialNumber = con.prepareStatement(selectBySerialNumberQ);
		InsertEquipment = con.prepareStatement(InsertEquipmentQ);
		
	}
	/*
	 * Returns a list of all equipment
	 */
	public List<Equipment> findAll() throws DataAccessException  {
		try {
			ResultSet rs = selectAll.executeQuery();
			List<Equipment> res = buildObjects(rs);
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
	public Equipment findBySerialNumber(int serialNumber) throws DataAccessException {
		Equipment equipment = null;
		try {
			selectBySerialNumber.setInt(1, serialNumber);
			ResultSet rs = selectBySerialNumber.executeQuery();
			if(rs.next()) {
				equipment = buildObject(rs);
				//System.out.println(employee.getName());
				//System.out.print(equipment);
				
			}
	
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find by serialNumber = " + serialNumber);
		}
		
		return equipment;
	}
	/*
	 * Builds equipment Object
	 */
	private Equipment buildObject(ResultSet rs) throws SQLException {
		Equipment equipment = new Equipment(
				rs.getInt("serialNumber"),
				rs.getString("eState"),
				(new EDescription(rs.getInt("eID")))
				);
		return equipment;
	}
	
	/*
	 * BuildObjects of employee list
	 */
	
	private List<Equipment> buildObjects(ResultSet rs) throws SQLException {
		List<Equipment> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildObject(rs));
			
			for(Equipment equipment: res) {
				System.out.println(equipment);
			}
		}
		return res;
	}
	@Override
	public boolean insertEquipment(Equipment equipment) throws DataAccessException {
		
		boolean wasInsertedOK;

		try {
			//"insert into equipment (serialNumber, eState, eID) values (?,?,?)";
			InsertEquipment.setInt(1, equipment.getSerialNumber());
			InsertEquipment.setString(2, equipment.geteState());
			InsertEquipment.setInt(3, equipment.getDescription().geteID());
			int rowsInserted = InsertEquipment.executeUpdate();
			wasInsertedOK = (rowsInserted == 1);
			
		} catch (SQLException e) {
			DataAccessException he = new DataAccessException(e, "Could not insert rows");
			throw he;
		}
		
		return wasInsertedOK;
	}
}

	
	
