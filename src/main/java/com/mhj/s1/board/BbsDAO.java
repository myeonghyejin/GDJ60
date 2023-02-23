package com.mhj.s1.board;

import java.util.List;

import com.mhj.s1.util.Pager;

public interface BbsDAO {
	
	//totalCount
	public Long getTotalCount(Pager pager) throws Exception;
	
	//Select(List)
	public List<BbsDTO> getBoardList(Pager pager) throws Exception;
	
	//Insert(add)
	public int setBoardAdd(BbsDTO bbsDTO) throws Exception;
	
	//Update
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception;
	
	//Delete
	public int setBoardDelete(BbsDTO bbsDTO) throws Exception;

}
