package edu.pnu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardRepository boardRepo;
	
	@Autowired
	public BoardServiceImpl(BoardRepository boardRepo) {
		this.boardRepo = boardRepo;
	}
	
	@Override
	public List<Board> getBoardList() {
		return boardRepo.findAll();		
	}

	@Override
	public Board getBoard(Integer id) {		
		return boardRepo.findById(id).get();
	}

	@Override
	public void insertBoard(String name, Board board) {		
		board.setCreateDate(new Date());
		board.setCnt(0);
		board.setWriter(name);
		boardRepo.save(board);		
	}

	@Override
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getId()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}

	@Override
	public void deleteBoard(Integer id) {
		Board findBoard = boardRepo.findById(id).get();		
		boardRepo.delete(findBoard);		
	}

	@Override
	public void increaseCnt(Integer id) {
		Board findBoard = boardRepo.findById(id).get();
		int cnt = findBoard.getCnt();
		cnt++;
		findBoard.setCnt(cnt);
		boardRepo.save(findBoard);
	}

}
