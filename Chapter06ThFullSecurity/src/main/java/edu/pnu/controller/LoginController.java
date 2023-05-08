package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {
	
	private final MemberService service;
	
	@Autowired
	public LoginController(MemberService service) {
		this.service = service;
	}
	
//	@GetMapping("/login")
//	public void loginView() {		
//	}
	
//	@PostMapping("/login")
//	public String login(Member member, Model model) {
//		Member findMember = service.getMember(member);	// findMember는 db에 등록되어 있는 member
//		
//		if (findMember != null && findMember.getPassword().equals(member.getPassword())) {
//			model.addAttribute("member", findMember);
//			return "redirect:getBoardList";
//		} else {
//			return "redirect:login";
//		}
//	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:";
	}
}
