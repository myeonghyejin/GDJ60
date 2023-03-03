package com.mhj.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhj.s1.util.Pager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	/** INSERT **/
	public boolean getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		memberDTO = memberDAO.getMemberLogin(memberDTO);
		
		//중복 아니면 true, 중복이면 false
		boolean check = true;
		
		if(memberDTO != null) {
			check = false;
		}
		
		return check;
	}
	
	//getMemberList
	public List<MemberDTO> getMemberList() throws Exception {
		return memberDAO.getMemberList();
	}
	
	//getMemberLogin
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		//memberDTO : Client에서 입력한 ID, PW
		MemberDTO result = memberDAO.getMemberLogin(memberDTO);
		//result : ID와 일치하는 모든 정보
		
		//PW Check
		if(result != null && memberDTO.getPw().equals(result.getPw())) {
			memberDTO.setPw(null);
			memberDTO.setRoleDTOs(result.getRoleDTOs());
			return memberDTO;
		} else {
			return null;
		}
	}
	
	public MemberDTO getMemberPage(MemberDTO memberDTO) throws Exception {
		return memberDAO.getMemberLogin(memberDTO);
	}
	
	/** INSERT **/
	//setMemberAdd
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		int result = memberDAO.setMemberAdd(memberDTO);
		result = memberDAO.setMemberRoleAdd(memberDTO);
		return result;
	}
	
	/** UPDATE **/
	//setMemberUpdate
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return memberDAO.setMemberUpdate(memberDTO);
	}
	
	/** DELETE **/
	//setMemberDelete
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		return memberDAO.setMemberDelete(memberDTO);
	}

}
