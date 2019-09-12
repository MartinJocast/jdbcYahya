package fr.formation.inti.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.utils.ConnectionUtils;
import fr.formation.inti.utils.Constants;

public class EmployeeDaoImpl implements IEmployeeDao{

	

	@Override
	public List<Employee> getAll() {
		List<Employee> list = new ArrayList<Employee>();
		Employee emp ;
		Connection con = null;
		try {
			con = ConnectionUtils.getMySQLConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Constants.SELECT_EMPLOYEE);
			
			while(rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setStartDate(rs.getDate(4));
				list.add(emp);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null )
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public Integer save(Employee e) {
		Connection con = null;
		Integer idEmp = 0;
		try {
			con = ConnectionUtils.getMySQLConnection();
			PreparedStatement pst = con.prepareStatement(Constants.INSERT_EMPLOYEE,1);
			pst.setString(1, e.getFirstName());
			pst.setString(2, e.getLastName());
			pst.setDate(3, new Date(e.getStartDate().getTime()));
			
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			
			if(rs.next())
				idEmp = rs.getInt(1);
			
		} catch (ClassNotFoundException err) {
			err.printStackTrace();
		} catch (SQLException err) {
			err.printStackTrace();
		}finally {
			try {
				if(con != null )
				con.close();
			} catch (SQLException err) {
				err.printStackTrace();
			}
		}
		
		return idEmp;
	}

	@Override
	public void update(Employee e) {
		
	}

	@Override
	public void delete(Employee e) {
		
	}

}
