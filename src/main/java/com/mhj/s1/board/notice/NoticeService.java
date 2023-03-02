package com.mhj.s1.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mhj.s1.bankbook.BankbookDTO;
import com.mhj.s1.board.BbsDAO;
import com.mhj.s1.board.BbsDTO;
import com.mhj.s1.board.BoardDTO;
import com.mhj.s1.board.BoardFileDTO;
import com.mhj.s1.board.BoardService;
import com.mhj.s1.util.FileManager;
import com.mhj.s1.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	/** Select **/
	//Select (List)
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(noticeDAO.getTotalCount(pager));
		return noticeDAO.getBoardList(pager);
	}

	//Select (Detail)
	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		return noticeDAO.getBoardDetail(boardDTO);
	}
	
	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return noticeDAO.getBoardFileDetail(boardFileDTO);
	}
	
	/** Insert **/
	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile[] multipartFiles, HttpSession session) throws Exception {
		int result = noticeDAO.setBoardAdd(bbsDTO);
		
		//1. file을 HDD에 저장
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		
		for(MultipartFile multipartFile : multipartFiles) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			
		String fileName = fileManager.fileSave(multipartFile, realPath);
					
		//2. DB에 Insert
		BoardFileDTO boardFileDTO = new BoardFileDTO();
		
		boardFileDTO.setNum(bbsDTO.getNum());
		boardFileDTO.setFileName(fileName);
		boardFileDTO.setOriName(multipartFile.getOriginalFilename());
		
		result = noticeDAO.setBoardFileAdd(boardFileDTO);
			
		}
		
		return result;
	}
	
	/** Update **/
	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return ;
	}
	
	/** Delete **/
	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		List<BoardFileDTO> ar = noticeDAO.getBoardFileList(bbsDTO);
		
		int result = noticeDAO.setBoardDelete(bbsDTO);
		
		if(result > 0) {
			String realPath = session.getServletContext().getRealPath("resources/upload/notice/");
			
			for(BoardFileDTO boardFileDTO : ar) {
				boolean check = fileManager.fileDelete(realPath, boardFileDTO.getFileName());		
			}
			
		}
		
		return result;
	}

}
