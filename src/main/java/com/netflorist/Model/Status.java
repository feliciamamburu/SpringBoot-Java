/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author User
 */
@Entity
public class Status implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private int statusId;
    private int name;  

    
    
      public Status() {
       
    }
      
    public Status(int statusId, int name) {
        this.statusId = statusId;
        this.name = name;
    }

    public int getStatusId() {
        return statusId;
    }

    public int getName() {
        return name;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public void setName(int name) {
        this.name = name;
    }
    
    
    
}
