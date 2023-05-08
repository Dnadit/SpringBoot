package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;

public interface BoardService {
	
	public List<Board> getBoardList();
	
	public Board getBoard(Integer id);
	
	public void insertBoard(String name, Board board);
	
	public void updateBoard(Board board);
	
	public void deleteBoard(Integer id);
	
	public void increaseCnt(Integer id);
	
}
