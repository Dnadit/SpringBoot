package edu.pnu.service;


import java.util.List;
import java.util.Map;

import edu.pnu.dao.log.LogDao;
import edu.pnu.dao.log.LogDaoFile;
import edu.pnu.dao.member.MemberDao;
import edu.pnu.dao.member.MemberDaoH2Impl;
import edu.pnu.domain.MemberVO;

public class MemberService {
	private MemberDao dao = new MemberDaoH2Impl();	
//	private LogDao logdao = new LogDaoH2();
	private LogDao logdao = new LogDaoFile();
	
	public List<MemberVO> getMembers() {	
		Map<String, Object> map = dao.getMembers();
		String method = (String) map.get("method");
		String sqlString = (String) map.get("sqlstring");
		boolean success = (boolean) map.get("success");		
		@SuppressWarnings("unchecked")
		List<MemberVO> list = (List<MemberVO>) map.get("list");
		
		logdao.addReq(method, sqlString, success);
		
		return list;
	}
	
	public MemberVO getMember(Integer id) {
		Map<String, Object> map = dao.getMember(id);
		MemberVO m = (MemberVO) map.get("member");
		String method = (String) map.get("method");
		String sqlString = (String) map.get("sqlstring");
		boolean success = (boolean) map.get("success");
		
		logdao.addReq(method, sqlString, success);
		return m;
	}
	
	public MemberVO addMember(MemberVO member) {
		Map<String, Object> map = dao.addMember(member);
		MemberVO m = (MemberVO) map.get("member");
		String method = (String) map.get("method");
		String sqlString = (String) map.get("sqlstring");
		boolean success = (boolean) map.get("success");
		
		logdao.addReq(method, sqlString, success);
		return m;
	}
	
	public MemberVO updateMember(MemberVO member) {
		Map<String, Object> map = dao.updateMember(member);
		MemberVO m = (MemberVO) map.get("member");
		String method = (String) map.get("method");
		String sqlString = (String) map.get("sqlstring");
		boolean success = (boolean) map.get("success");
		
		logdao.addReq(method, sqlString, success);
		return m;
	}
	
	public boolean deleteMember(Integer id) {
		Map<String, Object> map = dao.deleteMember(id);
		String method = (String) map.get("method");
		String sqlString = (String) map.get("sqlstring");
		boolean success = (boolean) map.get("success");
		
		logdao.addReq(method, sqlString, success);
		return success;
	}
}
