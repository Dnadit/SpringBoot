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
import edu.pnu.service.MemberService;

@RestController
public class MemberController {
	private MemberService memberService;	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	public MemberController() {
		this.memberService = new MemberService();
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		log.info("MemberController - getMembers()");		
		return memberService.getMembers();
	}

	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		log.info(String.format("MemberController - getMembe(%d)", id));		
		return memberService.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO member) {
		log.info(String.format("MemberController - addMember(%s)", member));		
		return memberService.addMember(member);
	}

	@PutMapping("/member")
	public MemberVO updateMember(MemberVO member) {
		log.info(String.format("MemberController - updateMember(%s)", member));		
		return memberService.updateMember(member);
	}
	
	@DeleteMapping("/member/{id}")
	public boolean deleteMember(@PathVariable Integer id) {
		log.info(String.format("MemberController - deleteMember(%d)", id));
		return memberService.deleteMember(id);
	}
}
