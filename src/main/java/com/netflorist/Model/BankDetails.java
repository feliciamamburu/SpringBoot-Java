/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author 
 */
@Entity
public class BankDetails implements Serializable  {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int bankDetailId;
    private String bankType;
    private String accNo;
    private String secretPin;
    private double bankBalance;

    public BankDetails() {
    }

    public BankDetails(String bankType, String accNo, String secretPin, double bankBalance) {
        
       
        this.bankType = bankType;
        this.accNo = accNo;
        this.secretPin = secretPin;
        this.bankBalance = bankBalance;
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

    public String getSecretPin() {
        return secretPin;
    }

    public void setSecretPin(String secretPin) {
        this.secretPin = secretPin;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }
    
    
    
    
    
    
    
    
}
