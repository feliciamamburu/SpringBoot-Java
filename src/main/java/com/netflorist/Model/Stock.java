/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.Model;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name="stock")
public class Stock implements Serializable {
        @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="stock_id")
    private Integer stock_id;
    @Column(name="product_image")
    private String image;
    @Column(name="stock_Name")
    private String name;
    @Column(name="prod_description")
    private String description;
    @Column(name="category")
    private String category;
     @Column(name="Price")
    private float price;
    
    
    public Stock() {
    }

    public Stock(Integer stock_id, String image, String name, String description,  String category,float price) {
        this.stock_id = stock_id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
      
    }

    public Integer getStock_id() {
        return stock_id;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

  

    public String getCategory() {
        return category;
    }

    public void setStock_id(Integer stock_id) {
        this.stock_id = stock_id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
    
    
}
