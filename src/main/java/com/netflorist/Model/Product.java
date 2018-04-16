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
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Transient;

/**
 *
 * @author
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prod_id")
    private Integer product_id;
    @Column(name = "product_image")
    private String image;
    @Column(name = "prod_Name")
    private String name;
    @Column(name = "prod_description")
    private String description;
    @Column(name = "Unity_Price")
    private float price;
    @Column(name = "category")
    private String category;
    @Column(name = "Prod_quantity")
   
    private Integer prod_quantity;
    @Column(name = "BatchQuantity")
    private Integer batchQuantity;
    @Column(name = "threshholdQty")
    private Integer threshholdQty;
    @Column(name = "Batch")
    private Integer bQuantity;

    public Product() {
    }

    public Product(Integer product_id, String image, String name, String description, float price, String category, Integer prod_quantity, Integer batchQuantity, Integer threshholdQty, Integer bQuantity) {
        this.product_id = product_id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.prod_quantity = prod_quantity;
        this.batchQuantity = batchQuantity;
        this.threshholdQty = threshholdQty;
        this.threshholdQty = bQuantity;

    }

    public Integer getProduct_id() {
        return product_id;
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

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Integer getProd_quantity() {
        return prod_quantity;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
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

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProd_quantity(Integer prod_quantity) {
        this.prod_quantity = prod_quantity;
        
    }

    public void setBatchQuantity(Integer batchQuantity) {
        this.batchQuantity = batchQuantity;
    }

    public Integer getBatchQuantity() {
        return batchQuantity;
    }

    public void setThreshholdQty(Integer threshholdQty) {
        this.threshholdQty = threshholdQty;
    }

    public Integer getThreshholdQty() {
        return threshholdQty;
    }

    public void setbQuantity(Integer bQuantity) {
        this.bQuantity = bQuantity;
    }

    public Integer getbQuantity() {
        return bQuantity;
    }

}
