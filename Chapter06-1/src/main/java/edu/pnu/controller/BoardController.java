package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@RestController
public class BoardController {
	private final BoardService service;
	
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@GetMapping("/board")
	public List<Board> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/board/{title}")
	public List<Board> findByTitleContaining(@PathVariable String title) {
		return service.findByTitleContaining(title);
	}
}
