package com.mhj.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mhj.s1.board.BbsDAO;
import com.mhj.s1.board.BbsDTO;
import com.mhj.s1.board.BbsService;
import com.mhj.s1.util.Pager;

@Service
public class BankbookCommentService implements BbsService {

	@Autowired
	private BbsDAO bankbookCommentDAO;
	
	/** Select **/
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		pager.makeNum(bankbookCommentDAO.getTotalCount(pager));
		return bankbookCommentDAO.getBoardList(pager);
	}

	/** Insert **/
	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile [] multipartFiles, HttpSession session) throws Exception {
		return bankbookCommentDAO.setBoardAdd(bbsDTO);
	}

	/** Delete **/
	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		return bankbookCommentDAO.setBoardDelete(bbsDTO);
	}
	
	/** Update **/
	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		return bankbookCommentDAO.setBoardUpdate(bbsDTO);
	}

}
