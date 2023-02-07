package com.mhj.s1.product;

public class ProductDTO {
	
	private Long productNum;
	private String productName;
	private String productDetail;
	private Double productRating;
	
	//getter, setter
	
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public Double getProductRating() {
		return productRating;
	}
	public void setProductRating(Double productRating) {
		this.productRating = productRating;
	}

}
