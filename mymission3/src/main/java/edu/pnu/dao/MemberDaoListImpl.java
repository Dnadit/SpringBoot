package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDaoListImpl implements MemberDao {
	List<MemberVO> list;
	
	public MemberDaoListImpl() {
		list = new ArrayList<>();
		for (int i = 1 ; i <= 5 ; i++) {
			list.add(new MemberVO(i, "1234", "이름"+i, new Date()));
		}
	}	

	@Override
	public List<MemberVO> getMembers() {
		return list;
	}

	@Override
	public MemberVO getMember(Integer id) {
		for(MemberVO member : list) {
			if(member.getId() == id)
				return member;
		}
		return null;
	}	
	
	@Override
	public MemberVO addMember(MemberVO vo) {
		if(vo.getName() != null && vo.getPass() != null) {
			vo.setId(list.size()+1);
			vo.setPass(vo.getPass());
			vo.setName(vo.getName());
			vo.setRegidate(new Date(System.currentTimeMillis()));
			list.add(vo);
			return vo;	
		} else {
			System.out.println("이름과 패스워드 모두 입력해주세요.");
			return vo;
		}
	}

	@Override
	public MemberVO updateMember(MemberVO member) {
		MemberVO m = getMember(member.getId());
		if(m != null) {
			if(member.getPass() != null)
				m.setPass(member.getPass());
			if(member.getName() != null)
				m.setName(member.getName());
			m.setRegidate(new Date(System.currentTimeMillis()));
			return m;
		}		
		return null;
	}

	@Override
	public boolean deleteMember(Integer id) {
		if(getMember(id) != null) {
			list.remove(getMember(id));
			return true;
		}
		return false;
	}

}
