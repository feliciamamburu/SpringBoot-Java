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
 * @author 
 */
@Entity
public class BankDetail implements Serializable  {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int bankDetailId;
    private String bankType;
    private String accNo;
    private String pin;
  

    public BankDetail() {
    }

    public BankDetail(String bankType, String accNo, String pin) {
        
       
        this.bankType = bankType;
        this.accNo = accNo;
        this.pin = pin;
      
    }

    
    public int getBankId() {
        return bankDetailId;
    }

    public void setBankId(int bankDetailId) {
        this.bankDetailId = bankDetailId;
    }
 
    
    
    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Object pin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   

  

   
    
    
}
