package com.mhj.s1.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mhj.s1.MyTestCase;

public class ProductDAOTest extends MyTestCase {

	@Autowired
	private ProductDAO productDAO;
	
	//getProductList
//	@Test
//	public void getProductListTest() throws Exception {
//		List<ProductDTO> ar = productDAO.getProductList();
//		//단정문
//		assertNotEquals(0, ar.size());
//	}

	//getProductDetail
	@Test
	public void getProductDetail() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(10L);
		productDTO = productDAO.getProductDetail(productDTO);
		assertNotNull(productDTO);
	}
	
	//insert
	@Test
	public void setProductAddTest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductNum(50L);
		productDTO.setProductName("kong pencil");
		productDTO.setProductDetail("so cute");
		int result = productDAO.setProductAdd(productDTO);
		assertEquals(1, result);
	}
	
}
