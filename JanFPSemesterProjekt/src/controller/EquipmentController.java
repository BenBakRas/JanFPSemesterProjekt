package controller;

import java.sql.SQLException;
import java.util.List;

import db.DBEquipment;
import db.DataAccessException;
import model.EDescription;
import model.Equipment;

public class EquipmentController {
	
	private DBEquipment dbEquipment;

	public EquipmentController() throws DataAccessException{
		try {
			dbEquipment = new DBEquipment();
		} catch (SQLException e) {
			throw new DataAccessException(e, "Can't create ProductDB");
		}
	}
	
	public List<Equipment> findAll() throws DataAccessException {
		return dbEquipment.findAll();
	}
	
	public Equipment findBySerialNumber(int serialNumber) throws DataAccessException {
		return dbEquipment.findBySerialNumber(serialNumber);
	}
	
	public boolean insertEquipment(int serialNumber, String eState, EDescription eID)throws DataAccessException {
		Equipment equipment = new Equipment(serialNumber, eState,eID);
		boolean wasInsertedOK = dbEquipment.insertEquipment(equipment);
		
		return wasInsertedOK;
	}

}
