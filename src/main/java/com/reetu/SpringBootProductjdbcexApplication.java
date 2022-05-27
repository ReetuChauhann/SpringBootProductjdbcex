package com.reetu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.reetu.bean.Product;
import com.reetu.dao.ProductRepo;

@SpringBootApplication
public class SpringBootProductjdbcexApplication implements CommandLineRunner{
	
	  @Autowired
	  ProductRepo pr;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProductjdbcexApplication.class, args);
	}

	
	 @Override
	 public void run(String... args) throws Exception{
		 
		 //Add product
//		 Product p = new Product();
//		 p.setPid(7);
//		 p.setPname("Hair Band");
//		 p.setPrice(70);
//		 String status = pr.addproduct(p);
//		 System.out.println(status);
		 
		 //GetallProduct
//		 List<Product> detail = pr.getAllProduct();
//		 if(!detail.isEmpty()) {
//			 for (Product product : detail) {
//				 System.out.println(product.getPid());
//				 System.out.println(product.getPname());
//				 System.out.println(product.getPrice());
//				 System.out.println("-----------");
//		        }
//		 }else {
//			 System.out.println("Product not found");
//		 }
//		
		 
		    //get product by name 
//		 Product product = pr.getProductbyname("facewash");
//		 if(product!= null) {
//			 System.out.println(product.getPid());
//			 System.out.println(product.getPname());
//			 System.out.println(product.getPrice());
//			 System.out.println("-----");
//		 }else {
//			 System.out.println("Product not found");
//		 }
//		 
		// view Product by Like Name
//		 List<Product> detail = pr.getProductlikename("comb");
//		 if(!detail.isEmpty()) {
//			 for (Product product : detail) {
//				 System.out.println(product.getPid());
//				 System.out.println(product.getPname());
//				 System.out.println(product.getPrice());
//				 System.out.println("------");
//				}
//		 }else {
//			 System.out.println("Product not found!");
//		 }
		 
		 //delete Product
//		String status = pr.deleteProduct("Hair Band");
//		System.out.println(status);
		 
		 //update product
	      Product p = new Product();
	      p.setPid(5);
	      p.setPname("Bodywash");
	      p.setPrice(500);
	      String status = pr.updateproduct("Liner", p);
	      System.out.println(status);
		 
   }
}
