package edu.pnu.controller;

import edu.pnu.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SecurityController {
		
	@GetMapping("/member")
	public void forMember() {
		System.out.println("Member 요청입니다.");		
	}
	
	@GetMapping("/manager")
	public void forManager() {
		System.out.println("Manager 요청입니다.");		
	}
	
	@GetMapping("/admin")
	public void forAdmin() {
		System.out.println("Admin 요청입니다.");		
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	@GetMapping("/loginSuccess")
	public String loginSuccess() {
		return "loginSuccess";
	}
}
