package com.belajar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belajar.models.entities.Product;
import com.belajar.services.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product create(@RequestBody   Product product){
        
        return productService.save(product); // klo gini, yang ke return dalaah data yang berhasil ke simpan

    }
    @GetMapping
    public Iterable<Product> findAll(){
        return productService.findAll();
    }
    @GetMapping("/{id}")
    public Product findProduct(@PathVariable("id") Long id){
        return productService.findOne(id);
 
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.save(product);
    } 

    @DeleteMapping("/{id}")
    public String removeOne(@PathVariable("id") Long id){
        productService.removeOn(id);
        return "berhasil terhapus";
    }
}


