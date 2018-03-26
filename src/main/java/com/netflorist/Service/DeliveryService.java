/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Service;

import com.netflorist.Model.Delivery;
import java.util.ArrayList;
import java.util.List;
import com.netflorist.Repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository delRep;
    private String delivery_id;

    public List<Delivery> ListDelivery() {
        List<Delivery> allDelivery = new ArrayList<>();
        delRep.findAll().forEach(allDelivery::add);
        return allDelivery;
    }

    public void saveDelivery(Delivery delivery) {
        delRep.save(delivery);
    }
    
  
    
     public String deleteSt(String delivery_id) {
        
        List<Delivery> list = new ArrayList<>();
        
        
        Iterable<Delivery> findAll = delRep.findAll();
        findAll.forEach(list::add);
        
        int sizeBefore = list.size();
        
        Delivery status =delRep.findByStatus(delivery_id);
        
        delRep.delete(status);
        
        Iterable<Delivery> findAllAfter = delRep.findAll();
        findAllAfter.forEach(list::add);
        
        int sizeAfter = list.size();
        
        if(sizeAfter <sizeBefore ){
            return "Deleted";
        }else{
            return "Fail to delete";
        }
    }

   
    
    
}