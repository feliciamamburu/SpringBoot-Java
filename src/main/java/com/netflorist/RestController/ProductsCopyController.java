/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.RestController;

import com.netflorist.Model.ProductsCopy;
import com.netflorist.Service.ProductsCopyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 
 */
@RestController
public class ProductsCopyController {
    
    @Autowired
    private ProductsCopyService prodsCopyService;
    private List<ProductsCopy> prods;
    
    @RequestMapping("/productCopy")
    public List<ProductsCopy> getAllCopies()
    {
        prods = new ArrayList<>();
        prodsCopyService.findAllproducts().forEach(prods::add);
        return prods;
    }  
    
    @RequestMapping(method = RequestMethod.POST,value = "/productCopy")
    public void saveProductCopy(@RequestBody ProductsCopy productCopy)
    {
        prodsCopyService.saveProductsCopy(productCopy);
    }
}
