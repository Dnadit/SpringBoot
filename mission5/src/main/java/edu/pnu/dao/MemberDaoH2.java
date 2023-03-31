package edu.pnu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository
public class MemberDaoH2 implements MemberDao {
	private Connection con = null;
	Map<String, Object> map = new HashMap<>();
	
	public MemberDaoH2() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}		
	}
	
	@Override
	public Map<String, Object> getMembers() {
		List<MemberVO> list = new ArrayList<>();
		Statement st;
		ResultSet rs;
		String query = "select * from member";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);				
			}
			map.put("list", list);
			map.put("sqlstring", query);			
		} catch (SQLException e) {
			map.put("sqlstring", e.getMessage());
			e.printStackTrace();
		}
		
		return map;
	}

	@Override
	public Map<String, Object> getMember(Integer id) {
		Statement st;
		ResultSet rs;
		String query = "select * from member where id=" + id;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt("id"));
				m.setPass(rs.getString("pass"));
				m.setName(rs.getString("name"));
				m.setRegidate(rs.getDate("regidate"));
				map.put("member", m);
				map.put("sqlstring", query);				
			}
		} catch (SQLException e) {
			map.put("sqlstring", e.getMessage());
			e.printStackTrace();
		}	
		
		return map;
	}
	
	private int maxIdNum() {		
		Statement st = null;
		ResultSet rs = null;
		String query = "select max(id) from member";
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
	public Map<String, Object> addMember(MemberVO member) {
		Statement st = null;
		int id = maxIdNum(); 
		
		String query = "insert into member values (" + id + ",'" + member.getPass().toString() + "','" + member.getName().toString() + "','" + new Date(System.currentTimeMillis()) + "')"; 
		try {
			st = con.createStatement();
			st.executeUpdate(query);
			map.put("member", member);
			map.put("sqlstring", query);			
		} catch (SQLException e) {
			map.put("sqlstring", e.getMessage());
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		Statement st = null;
		
		String query = "update member set pass=" + member.getPass() + ", name=" + member.getName() + ", regidate=" + new Date(System.currentTimeMillis());
		try {
			st = con.createStatement();
			st.executeUpdate(query);
			map.put("member", member);
			map.put("sqlstring", query);
		} catch (SQLException e) {
			map.put("sqlstring", e.getMessage());
			e.printStackTrace();
		}
		
		return map;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {
		Statement st = null;
		
		String query = "delete from member where id=" + id;
		
		try {
			st = con.createStatement();
			st.executeUpdate(query);
			map.put("sqlstring", query);
			map.put("issuccess", true);
		} catch (SQLException e) {
			map.put("sqlstring", e.getMessage());
			e.printStackTrace();
		}
		
		return map;
	}

}
