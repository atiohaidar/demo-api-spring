package com.belajar.models.entities;

import java.io.Serializable;
// ini class untuk bikin tabel nya
// Seperti DDL nya

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// jadi disini kita bikin tabel di dalem database tapi dari spring

@Entity // waktu input datannya, file uyang dibutuhkan cuman nama, deskripsi dan price, karena id udah dibikin otomatia
@Table(name = "tbl_product") // bikin tabel nya
// kita hubungin data tabel produk ke class produk
public class Product implements Serializable {
    private static final long serialVersionUID = 1L; // klo impement serializable, disarankan ada ini
    @Id // dibikin primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // bikin jadi auto increment

    private Long id; 
    @Column(name = "product_name", length = 100) // ini buat ngatur propertinnya, , misal lenght nya   100
    private String name; // ini jadi varchar klo di MYSQL
    @Column(name = "product_description", length = 100) // ini buat ngatur propertinnya, , misal lenght nya   100
    private String description;
    private double price;// ini jadi mumber
    public Product() {
    }
    public Product(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    

}
