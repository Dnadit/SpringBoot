package edu.pnu.dao.log;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogDaoH2 implements LogDao {
	private Connection con = null;

	public LogDaoH2() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	private int getNextId() {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String query = "select max(id) from dblog";
			st = con.createStatement();
			rs = st.executeQuery(query);
			rs.next();
			return rs.getInt(1) + 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	@Override
	public void addReq(String method, String sqlstring, boolean success) {
		PreparedStatement st = null;		
		int id = getNextId();
		
		try {
			st = con.prepareStatement("insert into dblog values (?,?,?,?,?)");
			st.setInt(1, id);
			st.setString(2, method);
			st.setString(3, sqlstring);
			st.setDate(4, new Date(System.currentTimeMillis()));
			st.setBoolean(5, success);
			st.executeUpdate();			
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}			
		}	
		
	}


}
