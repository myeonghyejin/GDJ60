package com.mhj.s1.bankbook;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mhj.s1.util.Pager;

@Controller
@RequestMapping(value="/bankbook/*")
public class BankbookController {
	
	@Autowired
	private BankbookService bankbookService;

	//getBankbookList
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView getBankbookList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BankbookDTO> ar = bankbookService.getBankbookList(pager);	//매개 변수 -> 객체 자체를 보내는 것이 아닌 객체의 주소를 보내는 것
		
		modelAndView.setViewName("bankbook/bankbookList");
		modelAndView.addObject("list", ar);	//객체 주소
		modelAndView.addObject("pager", pager);	//객체 주소
		return modelAndView;
	}
	
	//getBankbookDetail
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView getBankbookDetail(BankbookDTO bankbookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		bankbookDTO = bankbookService.getBankbookDetail(bankbookDTO);
		modelAndView.setViewName("bankbook/bankbookDetail");
		modelAndView.addObject("DTO", bankbookDTO);
		return modelAndView;
	}
	
	//setBankbookAdd (입력 폼으로 이동)
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView setBankbookAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("bankbook/bankbookAdd");
		return modelAndView;
	}
	
	//setBankbookAdd (DB에 INSERT)
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView setBankbookAdd(BankbookDTO bankbookDTO, MultipartFile pic, HttpSession Session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("Name : " + pic.getName());
		System.out.println("Original File Name : " + pic.getOriginalFilename());
		System.out.println("Size : " + pic.getSize());
		System.out.println(Session.getServletContext());
		int result = bankbookService.setBankbookAdd(bankbookDTO, pic);
		modelAndView.setViewName("redirect:./list");
		return modelAndView;
	}
	
	//setBankbookUpdate (수정 폼으로 이동)
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public ModelAndView setBankbookUpdate(BankbookDTO bankbookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		bankbookDTO = bankbookService.getBankbookDetail(bankbookDTO);
		modelAndView.setViewName("bankbook/bankbookUpdate");
		modelAndView.addObject("DTO", bankbookDTO);
		return modelAndView;
	}
	
	//setBankbookUpdate
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView setBankbookUpdate(BankbookDTO bankbookDTO, ModelAndView modelAndView) throws Exception {
		int result = bankbookService.setBankbookUpdate(bankbookDTO);
		modelAndView.setViewName("redirect:./detail?bookNum="+bankbookDTO.getBookNum().toString());
		return modelAndView;
	}
	
	//setBankbookDelete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView setBankbookDelete(BankbookDTO bankbookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int result = bankbookService.setBankbookDelete(bankbookDTO);
		modelAndView.setViewName("redirect:./list");
		return modelAndView;
	}
	
}	