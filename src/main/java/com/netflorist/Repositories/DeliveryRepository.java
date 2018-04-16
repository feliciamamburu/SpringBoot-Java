/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Repositories;

import com.netflorist.Model.Delivery;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author User
 */
//@Repository - fetches the specific exceptions and re-throws them as on of Springs exceptions eg error 404(page not found)
@Repository
//CrudRepository - uses CRUD(Create,Read,Update and Delete) functionalities
//Interfaces - collection of abstract classes
public interface DeliveryRepository extends CrudRepository <Delivery, Integer>{
   // @Query - Used when I want to generate my own query
    @Query("SELECT l FROM Delivery l WHERE l.deliveryId = :deliveryId")
  //@Param - the values that will go to the @Query statement will be parameters
	public ArrayList<Delivery> viewByDeliveryId(@Param("deliveryId") int deliveryId); 

    public Delivery findByDeliveryId(Integer deliveryId);
}
