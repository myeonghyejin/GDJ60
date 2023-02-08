package com.mhj.s1.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mhj.s1.MyTestCase;
import com.mhj.s1.bankbook.BankbookDAO;
import com.mhj.s1.bankbook.BankbookDTO;

public class BankbookDAOTest extends MyTestCase {
	
	@Autowired
	private BankbookDAO bankbookDAO;
	
	@Test
	public void getBankbookListTest() throws Exception {
		List<BankbookDTO> ar = bankbookDAO.getBankbookList();
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void setBankbookUpdateTest() throws Exception {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNum(8L);
		int result = bankbookDAO.setBankbookUpdate(bankbookDTO);
		assertEquals(1, result);
	}

}