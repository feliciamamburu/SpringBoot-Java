/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Repositories;

import com.netflorist.Model.Status;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author User
 */
public interface StatusRepository extends CrudRepository<Status, Integer>{
//    @Transactional
//    @Modifying
//    @Query("Update CustomerOrder o SET o.status = :status WHERE o..orderId = :orderId")
//    public int updateStatus(@Param("orderID") int orderId, @Param("status") String status);
}
