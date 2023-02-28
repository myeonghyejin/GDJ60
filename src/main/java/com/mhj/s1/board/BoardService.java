package com.mhj.s1.board;

import org.springframework.web.multipart.MultipartFile;

import com.mhj.s1.bankbook.BankbookDTO;

public interface BoardService extends BbsService {
	
	//Select (Detail)
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
	
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception;

}
