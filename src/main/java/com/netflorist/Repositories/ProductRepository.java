/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Repositories;

import com.netflorist.Model.Product;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 
 */
public interface ProductRepository extends CrudRepository<Product, Integer>{
    // @Query - Used when I want to generate my own query
	@Query("SELECT l FROM Product l WHERE l.product_id = :product_id")
	//@Param - the values that will go to the @Query statement will be parameters
	public ArrayList<Product> viewByProductId(@Param("product_id") int product_id);

    public Product findByName(String prodName);
}