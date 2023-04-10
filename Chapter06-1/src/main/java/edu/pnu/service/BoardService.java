package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.repository.BoardRepository;


@Service
public class BoardService {
	
	private final BoardRepository BoardRepo;
	
	@Autowired
	public BoardService(BoardRepository BoardRepo) {
		this.BoardRepo = BoardRepo;
	}
	
	public List<Board> getAll() {
		return BoardRepo.findAll();
	}
	
	public List<Board> findByTitleContaining(String title) {
		return BoardRepo.findByTitleContaining(title);
	}
}
