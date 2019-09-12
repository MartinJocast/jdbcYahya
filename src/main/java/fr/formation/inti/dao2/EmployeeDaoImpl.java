package fr.formation.inti.dao2;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(con != null )
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			PreparedStatement pst = con.prepareStatement(Constants.INSERT_EMPLOYEE,Statement.RETURN_GENERATED_KEYS);
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
		Connection con = null;
		try {
			con = ConnectionUtils.getMySQLConnection();
			PreparedStatement pst = con.prepareStatement(Constants.UPDATE_EMPLOYEE);
			pst.setString(1, e.getFirstName());
			pst.setString(2, e.getLastName());
			
			pst.executeUpdate();	
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
		
		
	}
	
	@Override
	public void delete(Employee e) {
		Connection con = null;
		try {
			con = ConnectionUtils.getMySQLConnection();
			PreparedStatement pst = con.prepareStatement(Constants.DELETE_EMPLOYEE);
			pst.setInt(1, e.getEmpId());
			
			pst.executeUpdate();	
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
		
		
	}

	@Override
	public Employee findById(Integer id) {
		Connection con = null;
		Employee emp = null;
		try {
			con = ConnectionUtils.getMySQLConnection();
			PreparedStatement pst = con.prepareStatement(Constants.SELECT_EMPLOYEE_BY_ID);
			pst.setInt(1, id);			
			ResultSet rs = pst.executeQuery();	
			
			if(rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setStartDate(rs.getDate(4));
			}
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
		return emp;
	}

}
