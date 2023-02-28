package com.mhj.s1.board.qna;

import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mhj.s1.board.BbsDTO;
import com.mhj.s1.board.BbsService;
import com.mhj.s1.board.BoardDTO;
import com.mhj.s1.board.BoardFileDTO;
import com.mhj.s1.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "qna";
	}
	
	//Select(List)
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BbsDTO> ar = qnaService.getBoardList(pager);
		
		modelAndView.addObject("list", ar);
		modelAndView.setViewName("board/list");
				
		return modelAndView;
	}
	
	//Insert (입력 폼으로 이동)
	@GetMapping("add")
	public ModelAndView setBoardAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("board/add");
		
		return modelAndView;
	}
	
	//Insert (DB에 Insert)
	@PostMapping("add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO, MultipartFile [] files, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = qnaService.setBoardAdd(qnaDTO, files, session);
		
		String message = "등록이 실패했쯤다!ㅠㅠ";
		
		if(result > 0) {
			message = "등록이 성공해부렀쯤다~~~~~~~~!!!!!!!!!";
		}
		
		modelAndView.addObject("result", message);
		modelAndView.addObject("URL", "./list");
		modelAndView.setViewName("common/result");
		
		return modelAndView;
	}
	
	@GetMapping("detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		BoardDTO boardDTO = qnaService.getBoardDetail(qnaDTO);
		
		modelAndView.addObject("DTO", boardDTO);
		modelAndView.setViewName("board/detail");
		
		return modelAndView;
	}
	
	@GetMapping("reply")
	public ModelAndView setReplyAdd(BoardDTO qnaDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("board/reply");
		
		return modelAndView;
	}
	
	@PostMapping("reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO, MultipartFile [] files) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = qnaService.setReplyAdd(qnaDTO);
		
		String message = "등록이 실패했쯤다!ㅠㅠ";
		
		if(result > 0) {
			message = "등록이 성공해부렀쯤다~~~~~~~~!!!!!!!!!";
		}
		
		modelAndView.setViewName("common/result");
		modelAndView.addObject("result", message);
		modelAndView.addObject("URL", "./detail?num="+qnaDTO.getNum());
		
		return modelAndView;
	}
	
	//Delete
	@PostMapping("delete")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("common/result");
		
		int result = qnaService.setBoardDelete(bbsDTO, session);
		
		String message = "삭제되지 않았습니다.";
				
		if(result > 0) {
			message = "삭제되었습니다.";
		}
		
		modelAndView.addObject("result", message);
		modelAndView.addObject("URL", "./list");
		
		return modelAndView;
	}
	
	@GetMapping("fileDownload")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		boardFileDTO = qnaService.getBoardFileDetail(boardFileDTO);
		
		modelAndView.addObject("boardFile", boardFileDTO);
		modelAndView.setViewName("fileDownloadView");
		
		return modelAndView;
	}

}
