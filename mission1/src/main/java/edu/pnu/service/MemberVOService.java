package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.MemberVO;

@Service
public class MemberVOService {
	
	//Date today = new Date();	
	private List<MemberVO> list = new ArrayList<>();	
	//SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");	
	
	public MemberVOService() {
		list.add(new MemberVO(1, "1111", "홍길동"));
		list.add(new MemberVO(2, "2222", "김길동"));
		list.add(new MemberVO(3, "3333", "이길동"));
		list.add(new MemberVO(4, "4444", "강길동"));
	}
	
	public List<MemberVO> getMembers() {
		return list;
	}
	
	public MemberVO getMember(@PathVariable Integer id) {		
		for (int i=list.size()-1; i >= 0; i--) {
			if (list.get(i).getId() == id)
				return list.get(i);
		}		
		return null;
	}
	
	public MemberVO addMember(MemberVO memberVO) {		 
		list.add(new MemberVO(memberVO));
		return list.get(list.size()-1);
	}
	
	public MemberVO updateMembers(MemberVO memberVO) {
		for (int i=list.size()-1; i >= 0; i--) {
			if (list.get(i).getId() == memberVO.getId()) {
				list.set(i, new MemberVO(memberVO));
				return list.get(i);
			}
		}
//		MemberVO m = getMember(memberVO.getId());
//		if (m != null) {
//			m = new MemberVO(memberVO);
//			return m;
//		}
		return null;
	}
	
	public MemberVO removeMember(@PathVariable Integer id) {
		for (int i=list.size()-1; i >= 0; i--) {
			if (list.get(i).getId() == id) {
				MemberVO m = list.get(i);
				list.remove(i);
				return m;
			}
		}
		return null;
	}
}
