package com.mhj.s1.board;

import com.mhj.s1.bankbook.BankbookDTO;

public interface BoardService extends BbsService {
	
	public BankbookDTO getBoardDetail(BoardDTO boardDTO) throws Exception;

}
