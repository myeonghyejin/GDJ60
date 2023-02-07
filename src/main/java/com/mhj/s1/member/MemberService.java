package com.mhj.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//getMemberList
	public List<MemberDTO> getMemberList() throws Exception {
		return memberDAO.getMemberList();
	}
	
	//memberJoin
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		return memberDAO.memberJoin(memberDTO);
	}

}
