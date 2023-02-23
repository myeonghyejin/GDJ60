package com.mhj.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.mhj.s1.MyTestCase;
import com.mhj.s1.board.BbsDTO;
import com.mhj.s1.util.Pager;

public class BankbookCommentDAOTest extends MyTestCase {

	@Autowired
	private BankbookCommentDAO bankbookCommentDAO;
	
	//Select(List)
	@Test
	public void getBoardListTest() throws Exception {
		Pager pager = new Pager();
		pager.setBookNum(309L);
		pager.setKind("writer");
		pager.setSearch("ch");
		pager.makeRow();
		//long count = bankbookCommentDAO.getTotalCount(pager);
		List<BbsDTO> ar = bankbookCommentDAO.getBoardList(pager);
		assertEquals(2L, ar.size());
	}

}
