package com.mhj.s1.board;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.mhj.s1.bankbook.BankbookDTO;

public interface BoardService extends BbsService {
	
	//Select (Detail)
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
	
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception;
	
	public int setBoardUpdate(BbsDTO bbsDTO, MultipartFile [] files, HttpSession session, Long [] fileNums) throws Exception;

	public int setBoardFileDelete(Long fileNum) throws Exception;
	
}
