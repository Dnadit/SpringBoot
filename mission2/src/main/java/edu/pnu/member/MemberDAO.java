package edu.pnu.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.MemberVO;

public class MemberDAO {	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement psmt;
	
	public MemberDAO() {	
		
		try {
			Class.forName("org.h2.Driver");
			
			String url = "jdbc:h2:tcp://localhost/~/springboot";
			String id = "sa";
			String pass = "";
			
			con = DriverManager.getConnection(url, id, pass);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
	public int increaseNum() {		
		String sql = "select max(id) ddd from member";
		int x = 0;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			int temp = rs.getInt("ddd");		
			x = temp + 1;
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<MemberVO> getMembers() {
		String query = "select * from member";
		List<MemberVO> list = new ArrayList<>();
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPass(rs.getString(3));
				vo.setRegidate(rs.getDate(4));
				
				list.add(vo);
			}
		} catch (SQLException e) {			
			e.printStackTrace();			
		}
		
		return list;
	}
	
	public MemberVO getMember(@PathVariable Integer id) {		
		String query = "select * from member where id=?";		
		MemberVO vo = new MemberVO();
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			
			while(rs.next()) {				
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPass(rs.getString(3));
				vo.setRegidate(rs.getDate(4));
			}
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}					
	}	
	
	public MemberVO addMember(MemberVO memberVO) {		 
		String query = "insert into member(id, name, pass) values(?,?,?)";		
		int num = increaseNum();
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, num);
			psmt.setString(2, memberVO.getName());
			psmt.setString(3, memberVO.getPass());
			psmt.executeUpdate();
			return getMember(num);
		} catch (SQLException e) {			
			e.printStackTrace();	
			return null;
		}
		
	}
	
	public MemberVO updateMembers(MemberVO memberVO) {
		try {			
			String query = "update member set ";
			int num = 0;
			if (memberVO.getName() != null) {
				query += "name=? ";
				num++;
			}
			if (num == 1)
				query += ",";
			if (memberVO.getPass() != null) {
				query += "pass=? ";
				num++;
			}			
			query += "where id=?";
			num++;			
			psmt = con.prepareStatement(query);
			psmt.setString(num-2, memberVO.getName());
			psmt.setString(num-1, memberVO.getPass());
			psmt.setInt(num, memberVO.getId());
			psmt.executeUpdate();
			return getMember(memberVO.getId());
		} catch (SQLException e) {			
			e.printStackTrace();	
			return null;
		}	
	}
	
	public MemberVO removeMember(@PathVariable Integer id) {
		String query = "delete from member where id=?";		
		
		try {
			MemberVO m = getMember(id);
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			psmt.executeUpdate();
			return m;
		} catch (SQLException e) {			
			e.printStackTrace();	
			return null;
		}
	}
	
}
