// Controller
package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberVOService;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
@RestController
public class MemberVOController {
	
	MemberVOService service = new MemberVOService();
	//LoggerFactory << lombok을 쓰지 않고 log에 메시지를 찍기 위함.

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
