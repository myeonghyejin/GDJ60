package com.mhj.s1.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	
	@RequestMapping(value="list")
	public String getProductList() {
		System.out.println("Product List");
		return "product/productList";
	}
	
	@RequestMapping(value="detail")
	public String getProductDetail() {
		System.out.println("Product Detail");
		return "product/productDetail";
	}
	
	@RequestMapping(value="productAdd")
	public void getProductAdd() {
		System.out.println("Product Add");
	}
	
	@RequestMapping(value="update")
	public ModelAndView update() {
		System.out.println("Product Update");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");
		return mv;		
	}

}
