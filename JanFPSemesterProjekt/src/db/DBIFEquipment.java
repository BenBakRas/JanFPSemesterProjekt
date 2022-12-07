package db;

import java.util.List;

import model.EDescription;
import model.Equipment;

public interface DBIFEquipment {

	List<Equipment> findAll() throws DataAccessException;
	Equipment findBySerialNumber(int serialNumber) throws DataAccessException;
	boolean insertEquipment(Equipment equipment) throws DataAccessException;
}
