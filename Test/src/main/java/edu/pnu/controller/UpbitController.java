package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.UpbitTicker;
import edu.pnu.service.UpbitService;

@RestController
public class UpbitController {
	
	private final UpbitService service;
	
	@Autowired
	public UpbitController(UpbitService service) {
		this.service = service;
	}
	
	@GetMapping("/getList")
	public void getList() {
		service.getTicker();
	}
}
