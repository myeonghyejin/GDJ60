package com.mhj.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mhj.s1.util.DBConnection;

@Repository
public class ProductDAO {
	
	//getMax
	public Long getProductNum()throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		Long num = rs.getLong(1);
		
		DBConnection.disConnection(rs, st, con);
		
		return num;
		
	}
	
	//--------------------------------------
	
	public List<ProductOptionDTO> getProductOptionList()throws Exception{
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOptionNum(rs.getLong("OPTIONNUM"));
			productOptionDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productOptionDTO.setOptionName(rs.getString("OPTIONNAME"));
			productOptionDTO.setOptionPrice(rs.getLong("OPTIONPRICE"));
			productOptionDTO.setOptionStock(rs.getLong("OPTIONSTOCK"));
			ar.add(productOptionDTO);
		}
		
		DBConnection.disConnection(rs,  st, con);
		
		return ar;
	}
	
	//--------------------------------------
	
	public int setAddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql="INSERT INTO PRODUCTOPTION (OPTIONNUM, PRODUCTNUM, OPTIONNAME, OPTIONPRICE, OPTIONAMOUNT) "
				+ "VALUES (PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, productOptionDTO.getProductNum());
		st.setString(2, productOptionDTO.getOptionName());
		st.setLong(3, productOptionDTO.getOptionPrice());
		st.setLong(4, productOptionDTO.getOptionStock());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		
		return result;
	}
	
	//--------------------------------------
	
	//getProductDetail
	public ProductDTO getProductDetail(ProductDTO productDTO)throws Exception{
		
		Connection con = DBConnection.getConnection();
		
		String sql ="SELECT * FROM PRODUCT WHERE PRODUCTNUM=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProductNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductRating(rs.getDouble("PRODUCTRATING"));
			productDTO.setProductDetail(rs.getString("PRODUCTDETAIL"));
		}else {
			productDTO=null;
		}
		DBConnection.disConnection(rs, st, con);
		return productDTO;
		
	}
	
	//--------------------------------------
	
	public List<ProductDTO> getProductList()throws Exception{
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCTNUM, PRODUCTNAME, PRODUCTRATING "
				+ "FROM PRODUCT ORDER BY PRODUCTRATING DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductRating(rs.getDouble("PRODUCTRATING"));
			ar.add(productDTO);
		}
		
		DBConnection.disConnection(rs, st, con);
		
		return ar;
	}
	
	//--------------------------------------
	
	public int setAddProduct(ProductDTO productDTO)throws Exception{
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCT (PRODUCTNUM, PRODUCTNAME, PRODUCTDETAIL, PRODUCTRATING) "
				+ "VALUES (?,?,?,0.0)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, productDTO.getProductNum());
		st.setString(2, productDTO.getProductName());
		st.setString(3, productDTO.getProductDetail());
		//st.setDouble(3, productDTO.getProductRating());
		
		int result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		return result;	
	}
	
}