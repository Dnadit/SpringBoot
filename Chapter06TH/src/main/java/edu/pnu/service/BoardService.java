package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.Board;

public interface BoardService {

	public List<Board> findAll();

	public Board findById(Integer id);
	
	public void insertBoard(Board board);

}