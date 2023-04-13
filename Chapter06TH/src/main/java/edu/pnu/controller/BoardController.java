package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardServiceImpl;

@Controller
public class BoardController {
	
	private final BoardServiceImpl service;
	
	@Autowired
	public BoardController(BoardServiceImpl service) {
		this.service = service;
	}
	
//	@GetMapping("/board")
//	public List<Board> findAll() {
//		return service.findAll();
//	}
	
	@GetMapping("/getBoardList")
	public void getBoardById(Model model) {			
		model.addAttribute("boardList", service.findAll());			
	}
	
	@GetMapping("/getBoard")
	public void getBoard(Integer id, Model model) {
		model.addAttribute("board", service.findById(id));		
	}
	
	@GetMapping("/insertBoard")
	public void insertBoard() {	
		
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, Model model) {
		service.insertBoard(board);
		model.addAttribute("boardList", service.findAll());
		return "redirect:getBoardList";
	}
}
