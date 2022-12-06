package controller;

import java.sql.SQLException;
import java.util.List;

import db.DBEDescription;
import db.DataAccessException;
import model.EDescription;


public class EDescriptionController {

	private DBEDescription dbEDescription;
	
	public EDescriptionController() throws DataAccessException{
		try {
			dbEDescription = new DBEDescription();
		} catch (SQLException e) {
			throw new DataAccessException(e, "Can't create ProductDB");
		}
	}
	
	public List<EDescription> findAll() throws DataAccessException {
		return dbEDescription.findAll();
	}
	
	public EDescription findByEID(int eID) throws DataAccessException {
		return dbEDescription.findByEID(eID);
	}
	
	public EDescription createEDescription(String eName, String model, int eID) {
		EDescription eDescription = new EDescription(eName, model, eID);
		
		System.out.println("Description added");
		return eDescription;
	}
	
	public boolean insertEDescription(String eName, String model) throws DataAccessException {
		EDescription eDescription = new EDescription(eName, model);
		boolean wasInsertedOK = dbEDescription.insertEDescription(eDescription);
		
		return wasInsertedOK;
	}
	
	
}
