package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
class Chapter06ThApplicationTests {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void insertBoard() {
		for (int i = 1; i <= 100; i++) {			
			boardRepo.save(Board.builder()
					.title("title" + i)
					.content("content" + i)
					.createDate(new Date())
					.writer("writer")
					.cnt(0).build());
		}
	}
	

}
