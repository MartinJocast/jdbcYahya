package fr.formation.inti.utils;

public class Constants {
	public static final String SELECT_EMPLOYEE = "SELECT EMP_ID,FIRST_NAME,LAST_NAME,START_DATE FROM bd.employee;";
	public static final String INSERT_EMPLOYEE = "INSERT INTO employee (FIRST_NAME, LAST_NAME, START_DATE) VALUES (?, ?, ?)" ;
}
