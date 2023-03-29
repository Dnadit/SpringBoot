package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.MemberVO;
import edu.pnu.member.MemberDAO;

@SpringBootTest
class Mission2ApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("이것은 테스트입니다.");
	}
	
	@Test
	void testMemberDAO() {
		System.out.println("이것은 MemberDAO를 테스트합니다.");
		
		MemberDAO memberDAO = new MemberDAO();
		
		List<MemberVO> list = memberDAO.getMembers();
		for(MemberVO m : list) {
			System.out.println(m);
		}
	}

}
