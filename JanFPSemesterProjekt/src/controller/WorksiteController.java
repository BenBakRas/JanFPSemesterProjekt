package controller;

import java.sql.SQLException;
import java.util.List;

import db.DBWorksite;
import db.DataAccessException;
import model.Worksite;

public class WorksiteController {


	private DBWorksite dbWorksite;
	
	public WorksiteController() throws DataAccessException{
		try {
			dbWorksite = new DBWorksite();
		} catch (SQLException e) {
			throw new DataAccessException(e, "Can't create ProductDB");
		}
	}

	public List<Worksite> findAll() throws DataAccessException {
		return dbWorksite.findAll();
	}
	
	public Worksite findByWID(int wID) throws DataAccessException {
		return dbWorksite.findByWID(wID);
	}
	
}
