package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.service.UpbitService;

@SpringBootTest
class TestApplicationTests {
	
	@Autowired
	private UpbitService up;
	
	@Test
	void contextLoads() {
		up.getTicker();
	}

}
