package db;

import java.util.List;

import model.Employee;

public interface DBIFEmployee {
	List<Employee> findAll() throws DataAccessException;
	Employee findByID(int ID) throws DataAccessException;
	boolean insertEmployee(Employee employee) throws DataAccessException;
}
