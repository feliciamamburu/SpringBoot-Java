/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Repositories;

import com.netflorist.Model.CustomerOrder;
import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 
 */
public interface CustomersOrderRepository extends CrudRepository<CustomerOrder, Integer>{
    
     @Query("SELECT l FROM CustomerOrder l WHERE l.orderId = :orderId")
	//@Param - the values that will go to the @Query statement will be parameters
	public ArrayList<CustomerOrder> findByOrderId(@Param("orderId") int orderId);

        @Transactional
        @Modifying
        @Query("update CustomerOrder l set l.status = :status where l.orderId = :orderId")
    public int updateStatus(@Param("orderId") int orderId, @Param("status") String status);
    

         
}
