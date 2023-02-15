package com.mhj.s1.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mhj.s1.MyTestCase;
import com.mhj.s1.bankbook.BankbookDAO;
import com.mhj.s1.bankbook.BankbookDTO;
import com.mhj.s1.util.Pager;

public class BankbookDAOTest extends MyTestCase {
	
	@Autowired
	private BankbookDAO bankbookDAO;
	
//	@Test
//	public void getBankbookListTest(Pager pager) throws Exception {
//		List<BankbookDTO> ar = bankbookDAO.getBankbookList(pager);
//		assertNotEquals(0, ar.size());
//	}
	
	@Test
	public void setBankbookUpdateTest() throws Exception {
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookNum(8L);
		bankbookDTO.setBookName("test");
		bankbookDTO.setBookDetail("testDetail");
		bankbookDTO.setBookRate(0.0);
		bankbookDTO.setBookSale(1);
		int result = bankbookDAO.setBankbookUpdate(bankbookDTO);
		assertEquals(1, result);
	}
	
	//insert
	@Test
	public void setBankbookAddTest() throws Exception {
		
		for (int i=0; i<30; i++) {
			Random r = new Random();
			double d = r.nextDouble();
			int num = (int)(d * 1000);
			d = num / 100.0;
		
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookName("콩콩 적금-"+i);
		bankbookDTO.setBookDetail("완전 좋아요이");
		bankbookDTO.setBookRate(d);
		bankbookDTO.setBookSale(1);
		
		int result = bankbookDAO.setBankbookAdd(bankbookDTO);
		}
	}

}