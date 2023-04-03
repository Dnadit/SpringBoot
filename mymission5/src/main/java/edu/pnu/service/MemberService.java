package edu.pnu.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDaoH2;
import edu.pnu.domain.MemberVO;
import edu.pnu.log.LogDaoH2;

@Service
public class MemberService {
	@Autowired
	private MemberDaoH2 dao;
	
	@Autowired
	private LogDaoH2 log;
	
	private boolean success = false;	
	
	@SuppressWarnings("unchecked")
	public List<MemberVO> getMembers() {
		Map<String, Object> map = dao.getMembers();
		
		String sqlstring = (String) map.get("sqlstring");
		
		if (map.get("list") != null)
			success = true;
		
		log.add("get", sqlstring, success);
		
		return (List<MemberVO>) map.get("list");
	}
	
	public MemberVO getMember(Integer id) {
		Map<String, Object> map = dao.getMember(id);
		
		String sqlstring = (String) map.get("sqlstring");
		
		if (map.get("member") != null)
			success = true;
		
		log.add("get", sqlstring, success);		
		
		return (MemberVO) map.get("member");
	}
	
	public MemberVO addMember(MemberVO member) {
		Map<String, Object> map = dao.addMember(member);
		
		String sqlstring = (String) map.get("sqlstring");
		
		if (map.get("member") != null)
			success = true;
		
		log.add("post", sqlstring, success);		
		
		return (MemberVO) map.get("member");
	}
	
	public MemberVO updateMember(MemberVO member) {
		Map<String, Object> map = dao.updateMember(member);
		
		String sqlstring = (String) map.get("sqlstring");
		
		if (map.get("member") != null)			
			success = true;
		
		log.add("put", sqlstring, success);
		
		return (MemberVO) map.get("member");
	}
	
	public boolean deleteMember(Integer id) {
		Map<String, Object> map = dao.deleteMember(id);
		
		String sqlstring = (String) map.get("sqlstring");
		
		if (map.get("issuccess") != null)
			success = true;
		
		log.add("delete", sqlstring, success);
		
		return (boolean) map.get("issuccess");
	}
}
