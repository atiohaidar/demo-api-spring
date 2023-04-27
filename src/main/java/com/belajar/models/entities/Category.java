package com.belajar.models.entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_categories")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false, unique = true)
    private String name;
    
    public Long getId() {
        return id;
    }
    @ManyToMany
    @JoinTable(
        name = "tbl_product_supplier", // ini buat bikin tabel baru untuk relasi many to many
        // bikin tabelnnya di category aja, jadi di supplier tinggal mappedby aja
        joinColumns = @JoinColumn(name = "product_id"), // ntar isinnya kedua ini
        inverseJoinColumns = @JoinColumn(name = "supplier_id")
        )
        private Set<Supplier> suppliers;
    public Set<Supplier> getSuppliers() {
        return suppliers;
    }
    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
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
    

    
}
