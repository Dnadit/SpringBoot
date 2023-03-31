package edu.pnu.dao.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberDao {
	private List<MemberVO> list;
	private Map<String, Object> map;
	
	public MemberDaoListImpl() {
		list = new ArrayList<>();
		for (int i = 1 ; i <= 5 ; i++) {
			list.add(new MemberVO(i, "1234", "이름"+i, new Date()));
		}
	}	

	@Override
	public Map<String, Object> getMembers() {
		map = new HashMap<>();
		map.put("method", "get");
		map.put("success", true);
		map.put("list", list);
		if (map == null)
			map.put("success", false);
		return map;
	}

	@Override
	public Map<String, Object> getMember(Integer id) {
		map = new HashMap<>();
		for(MemberVO member : list) {
			if(member.getId() == id)
				map.put("member", member);
				map.put("success", true);				
		}
		if (map == null)
			map.put("success", false);
		map.put("method", "get");
		return map;
	}	
	
	@Override
	public Map<String, Object> addMember(MemberVO vo) {
		map = new HashMap<>();
		if(vo.getName() != null && vo.getPass() != null) {
			vo.setId(list.size()+1);
			vo.setPass(vo.getPass());
			vo.setName(vo.getName());
			vo.setRegidate(new Date(System.currentTimeMillis()));
			list.add(vo);
			map.put("sucess", true);
		} else {
			System.out.println("이름과 패스워드 모두 입력해주세요.");
			map.put("sucess", false);
		}
		map.put("method", "post");
		map.put("member", vo);
		return map;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO member) {
		map = new HashMap<>();
		MemberVO m = (MemberVO) getMember(member.getId()).get("member");
		if(m != null) {
			if(member.getPass() != null)
				m.setPass(member.getPass());
			if(member.getName() != null)
				m.setName(member.getName());
			m.setRegidate(new Date(System.currentTimeMillis()));
			map.put("member", m);
			map.put("sucess", true);			
		}		
		if (map == null)
			map.put("sucess", false);
		map.put("method", "put");
		return map;
	}

	@Override
	public Map<String, Object> deleteMember(Integer id) {
		map = new HashMap<>();
		if(getMember(id) != null) {
			list.remove(getMember(id).get("member"));
			map.put("sucess", true);			
		}
		if (map == null)
			map.put("sucess", false);
		map.put("method", "delete");
		return map;
	}
}
