package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepo;
	
	@Autowired
	public BoardServiceImpl(BoardRepository boardRepo) {
		this.boardRepo = boardRepo;
	}
	
	@Override
	public List<Board> findAll() {
		return (List<Board>) boardRepo.findAll();		
	}
	
	@Override
	public Board findById(Integer id) {
		return boardRepo.findById(id).get();
	}
	
	@Override
	public void insertBoard(Board board) {
		board.setCreateDate(new Date());
		board.setCnt(0);
		boardRepo.save(board);
	}
}
