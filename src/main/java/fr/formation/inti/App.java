package fr.formation.inti;

import java.util.Date;
import java.util.List;

import fr.formation.inti.dao.EmployeeDaoImpl;
import fr.formation.inti.entities.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("============ dao : GetALL");
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		List<Employee> list = dao.getAll();
		for (Employee e : list)
			System.out.println(e);

		System.out.println("=============dao : save");
		Employee emp = new Employee();
		emp.setFirstName("test3");
		emp.setLastName("test3");
		emp.setStartDate(new Date());
		int empId = dao.save(emp);
		System.out.println(empId);
		
	}
}
