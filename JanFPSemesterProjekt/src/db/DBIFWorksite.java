package db;

import java.util.List;

import model.Worksite;

public interface DBIFWorksite {

	List<Worksite> findAll() throws DataAccessException;
	Worksite findByWID(int wID) throws DataAccessException;
	boolean insertWorksite(Worksite worksite) throws DataAccessException;
	
}
