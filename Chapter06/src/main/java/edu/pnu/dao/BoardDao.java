package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.Board;

public interface BoardDao {
	
	public List<Board> getAll();
	
	public List<Board> getByTitle(String title);
}
