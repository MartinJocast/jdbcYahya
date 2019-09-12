package fr.formation.inti.entities;

import java.util.HashSet;
import java.util.Set;




public class Department {

	private Integer deptId;
	private String deptNo;

	private String deptName;
	private String location;
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Department() {
	}

	public Department(Integer deptId, String deptName, String location) {
		this.deptId = deptId;
		this.deptNo = "D" + this.deptId;
		this.deptName = deptName;
		this.location = location;
	}


	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}


	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}


	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}