package fr.formation.inti.dao2;

import java.util.List;

import fr.formation.inti.entities.Employee;

public interface IEmployeeDao {

	
	public List<Employee> getAll();
	
	public Integer save(Employee e);
	
	public void update(Employee e);
	
	public void delete(Employee e);
	
	public Employee findById(Integer id);
}
