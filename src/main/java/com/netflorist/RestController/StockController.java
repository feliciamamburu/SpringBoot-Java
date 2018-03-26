/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.RestController;

import com.netflorist.Model.Stock;

import com.netflorist.Service.StockService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class StockController {
    
    
    
     @Autowired
    private StockService stockService;
    
    List<Stock> stockList = new ArrayList<>();
    
     @RequestMapping(value = "/rest-controller/requestProduct",method = RequestMethod.POST)
    public void requestProduct(@RequestBody Stock stock){
      stockService.requestProduct(stock);
     
    }
    
    @RequestMapping(value="/stock/all",method = RequestMethod.GET)
    public List<Stock> allStock(){
      return stockService.ListStock();
    }
    
   
      @RequestMapping(value = "/deleteStock/{name}", method = RequestMethod.GET)
    public String deleteStock(@PathVariable("name") String stockName) {
        System.out.println("=========== " + stockName);

        String message = stockService.deleteStock(stockName);
        
        System.out.println("=========== " + message);
        return message;
    }
    
       @RequestMapping(method = RequestMethod.POST,value = "/suppliedStock")
	//@RequestBody converts JSON format to java object
	//@PathVariable - identifies the path pattern used in URL for incoming data
	public void suppliedStock(@RequestBody Stock stock)
	{
		stockService.supplyStock(stock);
	}
    
}
