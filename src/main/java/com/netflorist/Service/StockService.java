/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Service;

import com.netflorist.Model.Stock;
import com.netflorist.Repositories.StockRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class StockService {
    @Autowired
    private StockRepository stockRep;
    
    public List<Stock> ListStock(){
        List<Stock> allStock = new ArrayList<>();
        stockRep.findAll().forEach(allStock::add);
        return allStock;
    }
    
    public void requestProduct(Stock stock){
        stockRep.save(stock);
    }
    
    
    public String deleteStock(String stockName) {
        
        List<Stock> list = new ArrayList<>();
        
        
        Iterable<Stock> findAll = stockRep.findAll();
        findAll.forEach(list::add);
        
        int sizeBefore = list.size();
        
        Stock stock = stockRep.findByName(stockName);
        
        stockRep.delete(stock);
        
        Iterable<Stock> findAllAfter = stockRep.findAll();
        findAllAfter.forEach(list::add);
        
        int sizeAfter = list.size();
        
        if(sizeAfter <sizeBefore ){
            return "Deleted";
        }else{
            return "Fail to delete";
        }
    }

  
	public void supplyStock(Stock stock) {
		stockRep.save(stock);
		
	}
}
