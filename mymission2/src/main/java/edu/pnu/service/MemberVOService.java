package edu.pnu.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.MemberVO;
import edu.pnu.member.MemberDAO;

public class MemberVOService {
	private MemberDAO dao = new MemberDAO();	
	
	public List<MemberVO> getMembers() {
		return dao.getMembers();
	}
	
	public MemberVO getMember(@PathVariable Integer id) {		
		return dao.getMember(id);
	}
	
	public MemberVO addMember(MemberVO memberVO) {		 
		return dao.addMember(memberVO);
	}
	
	public MemberVO updateMembers(MemberVO memberVO) {
		return dao.updateMembers(memberVO);
	}
	
	public MemberVO removeMember(@PathVariable Integer id) {
		return dao.removeMember(id);
	}
}
