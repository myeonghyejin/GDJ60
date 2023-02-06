package com.mhj.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mhj.s1.util.DBConnection;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.mhj.s1.product.ProductDAO.";
	
	//delete
	public int setProductDelete(Long productNum) throws Exception {
		int result = 0;
		
		//1. DB 연결
		Connection connection = DBConnection.getConnection();
		
		//2. SQL문 작성
		String sql = "DELETE PRODUCT WHERE PRODUCTNUM = ?";
		
		//3. SQL 미리 보냄
		PreparedStatement st = connection.prepareStatement(sql);
		
		//4. ? 세팅
		st.setLong(1, productNum);
		
		//5. 최종 전송 및 결과 처리
		result = st.executeUpdate();
		
		//6. 연결 해제
		DBConnection.disConnection(st, connection);
		
		return result;
	}
	
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
		
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
		
	}
	
	//--------------------------------------
	
	public List<ProductDTO> getProductList()throws Exception{

		return sqlSession.selectList(NAMESPACE+"getProductList");
	}
	
	//--------------------------------------
	
	public int setAddProduct(ProductDTO productDTO)throws Exception{

		return sqlSession.insert(NAMESPACE+"setAddProduct", productDTO);	
	}
	
}