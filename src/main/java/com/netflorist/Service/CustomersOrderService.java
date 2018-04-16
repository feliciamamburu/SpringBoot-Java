/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Service;

import com.netflorist.Model.CustomerOrder;

import com.netflorist.Repositories.CustomersOrderRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author
 */
@Service
public class CustomersOrderService {

//    HashMap map = new HashMap();
//    private CustomerOrder cOrderObj;

    @Autowired
    private CustomersOrderRepository customersOrderRepository;

    private List<CustomerOrder> customerOrders = new ArrayList<>();


    public List<CustomerOrder> findAllcustomerOrders() {
        customerOrders = new ArrayList<>();
        customersOrderRepository.findAll().forEach(customerOrders::add);
        return customerOrders;
    }

    public void saveCustomerOrder(CustomerOrder customerOrders) {
        CustomerOrder cOrderObj = new CustomerOrder();

        cOrderObj.setUserId(customerOrders.getUserId());
//        cOrderObj.setBankDetailId((int) customerOrders.getBankDetailId());
        cOrderObj.setQuantity(customerOrders.getQuantity());
        cOrderObj.setPrice(customerOrders.getPrice());
        cOrderObj.setStatus(customerOrders.getStatus());
        cOrderObj.setOrderedDate(customerOrders.getOrderedDate());
        customersOrderRepository.save(cOrderObj);
    }


 

    public void updateStatus(CustomerOrder status) {
        customersOrderRepository.save(status);
    }

        
  

    public String deleteOrder(Integer orderId) {
        
         List<CustomerOrder> list = new ArrayList<>();
        
        
        Iterable<CustomerOrder> findAll = customersOrderRepository.findAll();
        findAll.forEach(list::add);
        
        int sizeBefore = list.size();
        
       
        CustomerOrder order = customersOrderRepository.findByOrderId(orderId);
          
        
       customersOrderRepository.delete(order);
        
        Iterable<CustomerOrder> findAllAfter = customersOrderRepository.findAll();
        findAllAfter.forEach(list::add);
        
        int sizeAfter = list.size();
        
        if(sizeAfter <sizeBefore ){
            return "Deleted";
        }else{
            return "Fail to delete";
        }
    }

 
     
     
}
