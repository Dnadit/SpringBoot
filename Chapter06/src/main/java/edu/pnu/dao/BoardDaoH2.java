package edu.pnu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.Board;

@Repository
public class BoardDaoH2 implements BoardDao {
	private final DataSource dataSource;
	private Connection con;
	private List<Board> list;	
	
	@Autowired
	public BoardDaoH2(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private Connection getConnection() {
		try {
			con = dataSource.getConnection();
			return con;
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Board> getAll() {
		list = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		
		String query = "select * from Board";
		try {			
			st = getConnection().createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Board b = new Board();
				b.setSeq(rs.getLong("seq"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setCreateDate(rs.getTimestamp("create_date"));
				b.setCnt(rs.getLong("cnt"));
				list.add(b);
			}
			return list;
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
		return null;
	}
	
	@Override
	public List<Board> getByTitle(String title) {
		Statement st;
		ResultSet rs;
		list = new ArrayList<>();
		String query = "select * from board where title like " + "'%" + title + "%'";
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(query);
			while(rs.next()) {
				Board b = new Board();
				b.setSeq(rs.getLong("seq"));
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setCreateDate(rs.getTimestamp("create_date"));
				b.setCnt(rs.getLong("cnt"));
				list.add(b);
			}
			return list;
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return null;
	}
	
}
