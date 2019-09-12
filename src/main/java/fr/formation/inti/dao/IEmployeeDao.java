package fr.formation.inti.dao;

import java.util.List;

import fr.formation.inti.entities.Employee;

public interface IEmployeeDao {

	
	public List<Employee> getAll();
	
	public Integer save(Employee e);
	
	public void update(Employee e);
	
	public void delete(Employee e);
}
