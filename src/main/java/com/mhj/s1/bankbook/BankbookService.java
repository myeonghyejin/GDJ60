package com.mhj.s1.bankbook;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mhj.s1.util.FileManager;
import com.mhj.s1.util.Pager;

@Service
public class BankbookService {
	
	@Autowired
	private BankbookDAO bankbookDAO;
	
	//testcase에서 테스트 시 NullPointerException, 실제 Server에서는 괜찮음
	//API 추가
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private FileManager fileManager;

	//getBankbookList
	public List<BankbookDTO> getBankbookList(Pager pager) throws Exception {
		Long totalCount = bankbookDAO.getBankbookCount(pager);	//
		
		pager.makeNum(totalCount);
		pager.makeRow();
		
		return bankbookDAO.getBankbookList(pager);
	}
	
	//getBankbookDetail
	public BankbookDTO getBankbookDetail(BankbookDTO bankbookDTO) throws Exception {
		return bankbookDAO.getBankbookDetail(bankbookDTO);
	}
	
	//setBankbookAdd
	public int setBankbookAdd(BankbookDTO bankbookDTO, MultipartFile multipartFile) throws Exception {
		int result = bankbookDAO.setBankbookAdd(bankbookDTO);
		
		if(!multipartFile.isEmpty()) {
			//1. File을 HDD에 저장
			//	Project 경로가 아닌 OS가 이용하는 경로
			String realPath = servletContext.getRealPath("resources/upload/bankbook");
			System.out.println(realPath);
			String fileName = fileManager.fileSave(multipartFile, realPath);
			
			//2. DB에 저장
			BankbookImgDTO bankbookImgDTO = new BankbookImgDTO();
			bankbookImgDTO.setFileName(fileName);
			bankbookImgDTO.setOriName(multipartFile.getOriginalFilename());
			bankbookImgDTO.setBookNum(bankbookDTO.getBookNum());
			
			result = bankbookDAO.setBankbookImgAdd(bankbookImgDTO);
		}
		
		return result;
	}
	
	//setBankbookUpdate
	public int setBankbookUpdate(BankbookDTO bankbookDTO) throws Exception {
		return bankbookDAO.setBankbookUpdate(bankbookDTO);
	}
	
	//setBankbookDelete
	public int setBankbookDelete(BankbookDTO bankbookDTO) throws Exception {
		return bankbookDAO.setBankbookDelete(bankbookDTO);
	}
	
}