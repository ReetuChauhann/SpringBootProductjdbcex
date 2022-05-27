package com.reetu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.reetu.bean.Product;

@Repository
public class ProductRepo {
	
	                      @Autowired
	                      private JdbcTemplate jdbcTemplate;
	                      
	                      //to add a product
	                 public String addproduct(Product p) {
	                	 
	                	  try {
	                		    String query= "insert into detail values(?,?,?)";
	                		    jdbcTemplate.update(query, new Object[] {p.getPid(), p.getPname(), p.getPrice()});
							return "successs";
							
	                		 } catch (Exception e) {
							       return "Product already exist";
						} 
	                	 
	                 }
	                 
	                 // to get all the product
	                public List<Product> getAllProduct(){
	                	class ProductMapper implements RowMapper{
	                		
	                		public Product mapRow(ResultSet rs, int rowNum) throws  SQLException {
	                			
	                			Product p = new Product();
	                			p.setPid(rs.getInt("pid"));
	                			p.setPname(rs.getString("pname"));
	                			p.setPrice(rs.getInt("price"));
	                			return p;
	                			}

						 }
	                  final String query = "select * from detail";
	                  List<Product> p = jdbcTemplate.query(query, new ProductMapper());
	                  return p;
                    }
	                
	                // get Product by name
	               public Product getProductbyname(String name) {
	            	   
	            	  class ProductMapper implements RowMapper{
	            		  
	            		  public Product mapRow(ResultSet rs, int rowMap) throws SQLException{
	            			  
	            			  Product p= new Product();
	            			  p.setPid(rs.getInt("pid"));
	            			  p.setPname(rs.getString("pname"));
	            			  p.setPrice(rs.getInt("price"));
	            			  return p;
	            		  }
	            	  }
	            	  try {
	            		  
	            		  final String query = "select * from detail where pname=?";
		            	  Product p = (Product) jdbcTemplate.queryForObject(query, new ProductMapper(), new Object[] {name});
		            	  return p;
						
					} catch (Exception ex) {
						                           return null;
					}
	             }
	               
	               //get Product Like name
	               
	               public List<Product> getProductlikename(String name){
	            	   class ProductMapper implements RowMapper{
	            		   
	            		   public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
	            			   Product p = new Product();
	            			   p.setPid(rs.getInt("pid"));
	            			   p.setPname(rs.getString("pname"));
	            			   p.setPrice(rs.getInt("price"));
	            			   return p;
	            		   }
	            	   }
	            	    final String query = "select * from detail where pname like ?";
	            	    List<Product> p = jdbcTemplate.query(query, new ProductMapper(), new Object[] {"%"+name+"%"});
	            	    return p;
	               }
	               
	               //delete Product
	               public String deleteProduct(String name) {
	            	   
	            	   String query = "delete from detail where pname = ?";
	            	   int x = jdbcTemplate.update(query, new Object[] {name});
	            	   if(x!=0) 
	            		   return "Success";
	            	   else 
	            		   return "No Product found to delete";
	            	   }
	               
	               //Update product
	               public String updateproduct(String name, Product p) {
	            	  String query = "update detail set pid =?, pname=?, price =? where pname = ?";
	            	  int x = jdbcTemplate.update(query, new Object[] {p.getPid(), p.getPname(), p.getPrice(), name});
	            	  if(x!=0)
	            		  return "Success";
	            	  else
	            		  return "No Product found to update";
	               }
	               
                   
}
