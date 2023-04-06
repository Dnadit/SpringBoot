package edu.pnu;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

// @Test 어노테이션 주석 달면 그 메서드는 실행되지 않음.
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository boardRepo;
	
	//@Test
	public void BoardInsertTest() {
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			Board b = new Board();
			b.setTitle("title" + i);
			b.setContent("content");
			b.setWriter("writer");
			b.setCreateDate(new Date());
			b.setCnt(random.nextLong(101));
			
			boardRepo.save(b);
		}		
	}
	
	//@Test
	public void testGetBoard() {
		Board board = boardRepo.findById(1L).get();
		System.out.println(board.toString());
	}
	
	//@Test
	public void testUpdateBoard() {
		System.out.println("=== 1번 게시글 조회 ===");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("=== 1번 게시글 제목 수정 ===");
		board.setTitle("제목을 수정했습니다.");
		boardRepo.save(board);
	}
	
	//@Test
	public void testDeleteBoard() {
		boardRepo.deleteById(1L);
	}
	
	//@Test
	public void testTitleLike() {
		List<Board> list = boardRepo.findByTitleContaining("1");
		for (Board b : list) {
			System.out.println(b);
		}
	}
	
	//@Test
	public void testTitleCnt() {
		List<Board> list = boardRepo.findByTitleContainingAndCntGreaterThan("1", 50L);
				
		for (Board b : list)		
			System.out.println(b);
	}
	
	//@Test
	public void testCnt() {
		List<Board> list = boardRepo.findByCntGreaterThanEqualAndCntLessThanEqualOrderByCntAsc(10L, 50L);
				
		for (Board b : list)		
			System.out.println(b);
	}
	
	//@Test
	public void testTwoContainingOrderBy() {
		List<Board> list = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
				
		for (Board b : list)		
			System.out.println(b);
	}
	
	@Test
	public void test() {
		Pageable paging = PageRequest.of(0, 10);
		List<Board> list = boardRepo.queryAnnotationTest(paging);
		
		for (Board b : list)
			System.out.println(b);
	}
	
}
