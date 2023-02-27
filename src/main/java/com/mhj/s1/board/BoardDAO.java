package com.mhj.s1.board;

import java.util.List;

public interface BoardDAO extends BbsDAO {
	
	//Select (Detail)
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
	
	//Select (File List)
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception;
	
	//Insert (File Add)
	public int setBoardFileAdd(BoardFileDTO boardFileDTO) throws Exception;
	
}
