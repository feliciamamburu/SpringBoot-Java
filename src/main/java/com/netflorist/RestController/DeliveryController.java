/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.RestController;

import com.netflorist.Model.Delivery;
import com.netflorist.Service.DeliveryService;
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
//@RestController - indicates that it is a  Spring MVC controller using REST API
@RestController
public class DeliveryController {

    @Autowired
    public DeliveryService delService;

    public List<Delivery> delList = new ArrayList<>();

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public Delivery saveDelivery(@RequestBody Delivery delivery) {
        delService.saveDelivery(delivery);
        return delivery;
    }

    @RequestMapping(value = "/delivery/all", method = RequestMethod.GET)
    public List<Delivery> allDelivery() {

        return delService.ListDelivery();

    }
    
    @RequestMapping(value = "/deleteSt/{delivery_id}", method = RequestMethod.GET)
    public String deleteSt(@PathVariable("delivery_id") String delivery_id) {
        System.out.println("=========== " + delivery_id);

        String message = delService.deleteSt(delivery_id);
        
        System.out.println("=========== " + message);
        return message;
    }
   

}
