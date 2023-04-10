package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.BoardDaoH2;
import edu.pnu.domain.Board;

@Service
public class BoardService {
	private final BoardDaoH2 dao;
	private Board board;	
	
	@Autowired
	public BoardService(BoardDaoH2 dao) {
		this.dao = dao;
	}
	
	public List<Board> getAll() {
		return dao.getAll();
	}
	
	public List<Board> getByTitle(String title) {
		return dao.getByTitle(title);
	}
}
