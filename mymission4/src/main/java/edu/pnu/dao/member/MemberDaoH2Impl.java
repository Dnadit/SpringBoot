package edu.pnu.dao.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDaoH2Impl implements MemberDao {
	private Map<String, Object> map = null;
	private Connection con = null;
	
	public MemberDaoH2Impl() {
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
		map = new HashMap<>();
		Statement st = null;
		ResultSet rs = null;
		String query = "select * from member";
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt("id"));
				m.setPass(rs.getString("pass"));
				m.setPass(rs.getString("name"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);				
			}			
			map.put("success", true);			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}		
		if (map == null)
			map.put("success", false);
		map.put("list", list);
		map.put("method", "get");
		map.put("sqlstring", query);
		return map;
	}	
	
	@Override
	public Map<String, Object> getMember(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		map = new HashMap<>();
		String query = "select * from member where id=?";
		
		try {
			MemberVO m = new MemberVO();
			st = con.prepareStatement(query);
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();
			m.setId(rs.getInt("id"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setRegidate(rs.getDate("regidate"));
			map.put("member", m);
			map.put("success", true);
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
		if (map == null)
			map.put("success", false);
		map.put("method", "get");
		map.put("sqlstring", query);
		return map;
	}
	
	private int getNextId() {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			String query = "select max(id) from member";
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
	public Map<String, Object> addMember(MemberVO vo) {
		PreparedStatement st = null;
		int id = getNextId();
		map = new HashMap<>();
		String query = "insert into member values(?,?,?,?)";
		
		try {			
			st = con.prepareStatement(query);
			st.setInt(1, id);
			st.setString(2, vo.getPass());
			st.setString(3, vo.getName());
			st.setDate(4, new Date(System.currentTimeMillis()));
			st.executeUpdate();
			map.put("success", true);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}
		if (map == null)
			map.put("success", false);
		map.put("member", getMember(id));
		map.put("method", "post");
		map.put("sqlstring", query);
		return map;
	}
	
	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		PreparedStatement st = null;
		map = new HashMap<>();
		String query = "update member set name=?,pass=? where id=?";
		try {
			st = con.prepareStatement(query);
			st.setString(1, member.getName());
			st.setString(2, member.getPass());
			st.setInt(3, member.getId());
			st.executeUpdate();
			
			map.put("success", true);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (map == null)
			map.put("success", false);
		map.put("member", getMember(member.getId()));
		map.put("method", "put");
		map.put("sqlstring", query);
		return map;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {
		PreparedStatement st = null;
		map = new HashMap<>();
		String query = "delete from member where id=?";
		try {
			st = con.prepareStatement(query);
			st.setInt(1, id);
			if (st.executeUpdate() == 1)
				map.put("success", true);				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (map == null)
			map.put("success", false);	
		map.put("method", "delete");
		map.put("sqlstring", query);
		return map;
	}
}
