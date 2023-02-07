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
	@Test
	public void getProductListTest() throws Exception {
		List<ProductDTO> ar = productDAO.getProductList();
		//단정문
		assertNotEquals(0, ar.size());
	}

}
