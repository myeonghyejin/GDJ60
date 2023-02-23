package com.mhj.s1.board;

public interface BoardDAO extends BbsDAO {
	
	//Select(Detail)
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
	
}
