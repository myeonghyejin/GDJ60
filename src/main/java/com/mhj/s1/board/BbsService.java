package com.mhj.s1.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.mhj.s1.util.Pager;

public interface BbsService {
	
	//Select (List)
	public List<BbsDTO> getBoardList(Pager pager) throws Exception;
	
	//Insert (Add)
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile [] multipartFiles, HttpSession session) throws Exception;
	
	//Update
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception;
	
	//Delete
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception;

}