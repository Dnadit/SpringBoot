// Controller
package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberVOService;


//@Slf4j
@RestController
public class MemberVOController {
	
	private MemberVOService service = new MemberVOService();
	
//	LoggerFactory << lombok을 쓰지 않고 log에 메시지를 찍기 위함.	
//	private static final Logger log = LoggerFactory.getLogger(MemberVOController.class);
//	public MemberVOController() {
//		log.info("MemberVOController 생성자 호출");
//		
//		log.error("error Message입니다.");
//		log.warn("Warn Message입니다.");
//		log.info("info Message입니다.");
//		log.debug("debug Message입니다.");
//		log.trace("trace Message입니다.");
//	}

	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		//log.info("getMembers: " + service.getMembers());
		System.out.println("getMembers: " + service.getMembers());
		return service.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		System.out.println("getMember: " + id);
		return service.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		System.out.println("addMember: " + memberVO.toString());
		return service.addMember(memberVO);
	}
	
	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
		System.out.println("updateMembers: " + memberVO.toString());
		return service.updateMembers(memberVO);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable Integer id) {		
		System.out.println("removeMember: " + id);
		return service.removeMember(id);		
	}
}
