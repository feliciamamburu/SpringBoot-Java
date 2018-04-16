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

//    public List<Delivery> ListDelivery() {
//        List<Delivery> allDelivery = new ArrayList<>();
//        delRep.findAll().forEach(allDelivery::add);
//        return allDelivery;
//    }

    public void saveDelivery(Delivery deliveryId) {
        delRep.save(deliveryId);
    }

    
      public List<Delivery> getDelivery() {
        List<Delivery> allDelivery = new ArrayList<>();
        delRep.findAll().forEach(allDelivery::add);
        return allDelivery;
    }

  

}
