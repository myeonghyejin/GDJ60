package com.mhj.s1.board.qna;

import java.io.File;
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
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	/** Select **/
	//Select (List)
	@Override
	public List<BbsDTO> getBoardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(qnaDAO.getTotalCount(pager));
		return qnaDAO.getBoardList(pager);
	}
	
	//Select (Detail)
	@Override
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getBoardDetail(boardDTO);
	}
	
	@Override
	public BoardFileDTO getBoardFileDetail(BoardFileDTO boardFileDTO) throws Exception {
		return qnaDAO.getBoardFileDetail(boardFileDTO);
	}


	/** Insert **/
	//Insert (Add)
	@Override
	public int setBoardAdd(BbsDTO bbsDTO, MultipartFile [] multipartFiles, HttpSession session) throws Exception {
		int result = qnaDAO.setBoardAdd(bbsDTO);
		
		//file HDD에 저장
		String realPath = session.getServletContext().getRealPath("resources/upload/qna/");
		System.out.println(realPath);
		
		for(MultipartFile multipartFile : multipartFiles) {
		
			if(multipartFile.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(multipartFile, realPath);
		
		//DB에 Insert
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setNum(bbsDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			
			result = qnaDAO.setBoardFileAdd(boardFileDTO);
			
		}
		
		return result;
	}

	//Insert (Reply)
	public int setReplyAdd(QnaDTO qnaDTO) throws Exception {
		//QNA DTO
		//num : 부모의 글 번호
		//writer. title, contents : 답글로 입력한 값
		//ref : null
		//step : null
		//depth : null
		//1. 부모의 정보를 조회
		QnaDTO parent = (QnaDTO)qnaDAO.getBoardDetail(qnaDTO);
		
		//ref : 부모의 ref
		qnaDTO.setRef(parent.getRef());
		
		//set : 부모의 step + 1
		qnaDTO.setStep(parent.getStep()+1);
		
		//depth : 부모의 depth + 1
		qnaDTO.setDepth(parent.getDepth()+1);
		
		//2. Step Update
		int result = qnaDAO.setStepUpdate(parent);
		
		//3. 답글 Insert
		result = qnaDAO.setReplyAdd(qnaDTO);
		
		return result;
	}	
	
	/** Update **/
	@Override
	public int setBoardUpdate(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/** Delete **/
	@Override
	public int setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		//파일이 지워지기 전 미리 조회
		List<BoardFileDTO> ar = qnaDAO.getBoardFileList(bbsDTO);
		
		int result = qnaDAO.setBoardDelete(bbsDTO);
		
		if(result > 0) {			
			String realPath = session.getServletContext().getRealPath("resources/upload/qna/");
			
			for(BoardFileDTO boardFileDTO : ar) {
				boolean check = fileManager.fileDelete(realPath, boardFileDTO.getFileName());
			}
			
		}
		return result;
	}
	
}
