package com.mhj.s1.member;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mhj.s1.util.DBConnection;
import com.mhj.s1.util.Pager;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.mhj.s1.member.MemberDAO.";
	
	/** SELECT **/
	//getMemberList
	public List<MemberDTO> getMemberList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getMemberList");
	}
	
	//getMemberLogin
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getMemberLogin", memberDTO);
	}
	
	/** INSERT **/
	//setMemberAdd
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setMemberAdd", memberDTO);
	}
	
	//setMemberRoleAdd
	public int setMemberRoleAdd(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setMemberRoleAdd", memberDTO);
	}
	
	/** UPDATE **/
	//setMemberUpdate
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setMemberUpdate", memberDTO);
	}
	
	/** DELETE **/
	//setMemberDelete
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"setMemberDelete", memberDTO);
	}

}
