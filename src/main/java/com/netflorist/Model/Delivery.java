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
import javax.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name = "delivery")
public class Delivery implements Serializable {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int delivery_id;
	private String province;
	private String city;
	private String houseNo;
        private String street;
        private String status;
        
	public Delivery() {
		
	}
        
	public Delivery(int delivery_id, String province, String city, String houseNo, String street, String status) {
		
		this.delivery_id = delivery_id;
                this.province =province;
		this.city = city;
		this.street = street;
                this.status = status;
	}

    public int getDelivery_id() {
        return delivery_id;
    }

  

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	
	
	}

