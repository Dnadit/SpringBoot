package edu.pnu.dao;

import java.util.Map;

import edu.pnu.domain.MemberVO;

public interface MemberDao {
	
	public Map<String, Object> getMembers();
	
	public Map<String, Object> getMember(Integer id);
	
	public Map<String, Object> addMember(MemberVO member);
	
	public Map<String, Object> updateMember(MemberVO member);
	
	public Map<String, Object> deleteMember(Integer id);
}
