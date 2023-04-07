package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class RealationMappingTest_1 {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	//@Test
	public void testManyToOneInsert() {
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("member111");
		member1.setName("둘리");
		member1.setRole("User");
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("member222");
		member2.setName("도우너");
		member2.setRole("Admin");
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member1);	// 이 시점에서 member1.boardList에 member1이 추가 된다.
			board.setTitle("둘리가 등록한 게시글 " + i);
			board.setContent("둘리가 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
		}
		memberRepo.save(member1);	// member1이 영속화되면서, CascadeType.ALL에 의해서 연관되어 있는 board도 영속화 됨.
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setMember(member2);
			board.setTitle("도우너가 등록한 게시글 " + i);
			board.setContent("도우너가 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
		}
		memberRepo.save(member2);
	}
	
	@Test
	public void testManyToOneSelect() {
		Board board = boardRepo.findById(5L).get();
		
		System.out.println("[ " + board.getSeq() + "번 게시글 정보 ]");
		System.out.println("제목 : " + board.getTitle());
		System.out.println("내용 : " + board.getContent());
		System.out.println("작성자 : " + board.getMember().getName());
		System.out.println("작성자 권한 : " + board.getMember().getRole());
	}
	
	@Test
	public void testTwoWayMapping() {
		Member member = memberRepo.findById("member1").get();
		
		System.out.println("=".repeat(30));
		System.out.println(member.getName() + "가(이) 저장한 게시글 목록");
		System.out.println("=".repeat(30));
		List<Board> list = member.getBoardList();
		for (Board b : list) {
			System.out.println(b.toString());
		}
	}
	
	//@Test
	public void testCascadeDelete() {
		memberRepo.deleteById("member1");
	}
}