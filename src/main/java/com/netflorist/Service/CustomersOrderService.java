/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Service;

import com.netflorist.Model.CustomerOrder;
import com.netflorist.Model.ProductsCopy;
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
    
    HashMap map = new HashMap();
    private  CustomerOrder cOrderObj;
    
   
    
    @Autowired
    private CustomersOrderRepository customersOrderRepository;
    
    private List<CustomerOrder> customerOrders= new ArrayList<>();
    
    List<ProductsCopy> productsCopyList = new ArrayList<ProductsCopy>();
    
    public List<CustomerOrder> findAllcustomerOrders()
    {
        customerOrders = new ArrayList<>();
        customersOrderRepository.findAll().forEach(customerOrders::add);
        return customerOrders; 
    }
    
    public void saveCustomerOrder(CustomerOrder  customerOrders){
        CustomerOrder cOrderObj = new CustomerOrder();
        
        cOrderObj.setUserId(customerOrders.getUserId());
//        cOrderObj.setBankDetailId((int) customerOrders.getBankDetailId());
        cOrderObj.setQuantity(customerOrders.getQuantity());
        cOrderObj.setPrice(customerOrders.getPrice());
        cOrderObj.setStatus(customerOrders.getStatus());
        cOrderObj.setOrderedDate(customerOrders.getOrderedDate());
        customersOrderRepository.save(cOrderObj);
    }
    
    
//    public HashMap upDateOrderStatus(CustomerOrder order) {
//
//        CustomerOrder statusOrder = customersOrderRepository.findOne(order.getOrderId());
//
//        if (statusOrder.getOrderId()== order.getOrderId() ) {
//           customersOrderRepository.save(order);
//            message = "Order For: " + statusOrder.getStatus()+ " Have Been Changed To " + order.getStatus();
//            status = "success";
//        }
//        map.put("status", status);
//        map.put("message", message);
//        return map;
//    }

    public int updateStatus(int orderID, String statusId)
    {
        return customersOrderRepository.updateStatus(orderID, statusId);
    }
    

    

   
}
