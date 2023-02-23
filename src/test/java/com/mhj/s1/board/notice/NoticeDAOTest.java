package com.mhj.s1.board.notice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mhj.s1.MyTestCase;
import com.mhj.s1.board.BbsDTO;
import com.mhj.s1.util.Pager;

public class NoticeDAOTest extends MyTestCase {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getBoardListTest() throws Exception {
		Pager pager = new Pager();
		pager.setNum(35L);
		pager.setKind("writer");
		pager.setSearch("관리자");
		pager.makeRow();
//		long count = noticeDAO.getTotalCount(pager);
		List<BbsDTO> ar = noticeDAO.getBoardList(pager);
		assertNotEquals(0, ar.size());
	}

}
