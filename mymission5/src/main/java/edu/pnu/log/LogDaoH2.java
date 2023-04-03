package edu.pnu.log;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
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
	
	private int maxIdNum() {		
		Statement st = null;
		ResultSet rs = null;
		String query = "select max(id) from dblog";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			rs.next();
			return rs.getInt(1) + 1;
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return 0;
	}
	
	@Override
	public void add(String method, String sqlstring, boolean success) {
		PreparedStatement st = null;		
		String query = "insert into dblog values(?,?,?,?,?)";
		int id = maxIdNum();
		
		try {
			st = con.prepareStatement(query);
			st.setInt(1, id);
			st.setString(2, method);
			st.setString(3, sqlstring);
			st.setDate(4, new Date(System.currentTimeMillis()));
			st.setBoolean(5, success);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
