/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
//import java.util.List;
import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author
 */
@Entity
public class CustomerOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int quantity;
    private double price;
    private String status;
    @Temporal(TemporalType.DATE)
    private Date orderedDate;
    private int userId;
    

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ProductsCopy.class)
    private Collection<ProductsCopy> prodsInCart = new ArrayList<ProductsCopy>();

    public CustomerOrder() {
    }

    public CustomerOrder(int userId,  int quantity, double price, String status, Date orderedDate) {

        this.userId = userId;
//        this.bankDetailId = bankDetailId;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.orderedDate = orderedDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

//    public int getBankDetailId() {
//        return bankDetailId;
//    }
//
//    public void setBankDetailId(int bankDetailId) {
//        this.bankDetailId = bankDetailId;
//    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Collection<ProductsCopy> getProdsInCart() {
        return prodsInCart;
    }

    public void setProdsInCart(Collection<ProductsCopy> prodsInCart) {
        this.prodsInCart = prodsInCart;
    }

}
