package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepo;
	
	@Autowired
	public MemberServiceImpl(MemberRepository memberRepo) {
		this.memberRepo = memberRepo;
	}
	
	public Member getMember(Member member) {
		Member findMember = memberRepo.findById(member.getId()).get();
		if (findMember != null)
			return findMember;
		return null;
	}
}
