package db;

import java.util.List;

import model.EDescription;
import model.Equipment;

public interface DBIFEquipment {

	List<Equipment> findAll() throws DataAccessException;
	
	Equipment findBySerialNumber(int serialNumber) throws DataAccessException;

	public Equipment insertEquipment(Equipment equipment) throws DataAccessException;
}
