package com.mhj.s1.member;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mhj.s1.util.DBConnection;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.mhj.s1.member.MemberDAO.";
	
	//getMemberList
	public List<MemberDTO> getMemberList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getMemberList");
	}
	
	//memberJoin
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
	}

}
