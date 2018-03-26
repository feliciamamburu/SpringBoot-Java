/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Repositories;

import com.netflorist.Model.Stock;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author User
 */
public interface StockRepository extends CrudRepository<Stock, Integer>{
     // @Query - Used when I want to generate my own query
	@Query("SELECT l FROM Stock l WHERE l.stock_id = :stock_id")
	//@Param - the values that will go to the @Query statement will be parameters
	public ArrayList<Stock> findByStockId(@Param("stock_id") int stock_id);

public Stock findByName(String stockName);

    
}
