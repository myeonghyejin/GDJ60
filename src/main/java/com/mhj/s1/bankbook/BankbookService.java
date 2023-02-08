package com.mhj.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankbookService {
	
	@Autowired
	private BankbookDAO bankbookDAO;

	//getBankbookList
	public List<BankbookDTO> getBankbookList() throws Exception {
		return bankbookDAO.getBankbookList();
	}
	
	//getBankbookDetail
	public BankbookDTO getBankbookDetail(BankbookDTO bankbookDTO) throws Exception {
		return bankbookDAO.getBankbookDetail(bankbookDTO);
	}
	
	//setBankbookAdd
	public int setBankbookAdd(BankbookDTO bankbookDTO) throws Exception {
		return bankbookDAO.setBankbookAdd(bankbookDTO);
	}
	
	//setBankbookUpdate
	public int setBankbookUpdate(BankbookDTO bankbookDTO) throws Exception {
		return bankbookDAO.setBankbookUpdate();
	}
	
	//setBankbookDelete
	public int setBankbookDelete(BankbookDTO bankbookDTO) throws Exception {
		return bankbookDAO.setBankbookDelete();
	}
	
}