/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Service;

import com.netflorist.Model.Product;

import com.netflorist.Repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository prodRep;
    
    public List<Product> listProducts(){
        List<Product> allProducts = new ArrayList<>();
        prodRep.findAll().forEach(allProducts::add);
        return allProducts;
    }
    
    
    public void addProduct(Product prod){
        prodRep.save(prod);
    }
    
    
    public void removeProd(Product prod){
        prodRep.delete(prod);
    }
   
    
 public String deleteProd(String prodName) {
        
        List<Product> list = new ArrayList<>();
        
        
        Iterable<Product> findAll = prodRep.findAll();
        findAll.forEach(list::add);
        
        int sizeBefore = list.size();
        
        Product prod = prodRep.findByName(prodName);
        
        prodRep.delete(prod);
        
        Iterable<Product> findAllAfter = prodRep.findAll();
        findAllAfter.forEach(list::add);
        
        int sizeAfter = list.size();
        
        if(sizeAfter <sizeBefore ){
            return "Deleted";
        }else{
            return "Fail to delete";
        }
    }

    
  
	public void updateProduct(Product product) {
		prodRep.save(product);
		
	}
        
     
        
}
  