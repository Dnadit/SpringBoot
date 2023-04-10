package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.DBoard;
import edu.pnu.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/board")
	public List<DBoard> getBoardList() {
		return boardService.getBoardList();
	}
	
//	@GetMapping("/board")
//	public List<DBoard> getBoard(Long seq) {
//		if (seq == null) return boardService.getBoardList(); 
//		
//		List<DBoard> list = new ArrayList<>();		
//		list.add(boardService.getBoard(seq));
//		return list;
//	}
//	
//	@GetMapping("/board/{seq}")
//	public DBoard getBoardByPath(@PathVariable Long seq) {
//		return boardService.getBoard(seq);
//	}
}
