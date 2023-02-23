package com.mhj.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhj.s1.board.BbsDAO;
import com.mhj.s1.board.BbsDTO;
import com.mhj.s1.board.BbsService;
import com.mhj.s1.util.Pager;

@Service
public class BankbookCommentService implements BbsService {

	@Autowired
	private BbsDAO bankbookCommentDAO;
	
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		pager.makeNum(bankbookCommentDAO.getTotalCount(pager));
		return bankbookCommentDAO.getBoardList(pager);
	}

	@Override
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
