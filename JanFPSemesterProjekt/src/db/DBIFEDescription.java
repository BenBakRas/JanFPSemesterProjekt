package db;

import java.util.List;

import model.EDescription;


public interface DBIFEDescription {

	List<EDescription> findAll() throws DataAccessException;
	EDescription findByEID(int eID) throws DataAccessException;

	
}
