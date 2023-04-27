package com.belajar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belajar.dto.ResponseData;
import com.belajar.models.entities.Product;
import com.belajar.services.ProductService;


@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseData<Product>> create( @RequestBody   Product product){ // kasih tau klo ini kudu di validasi dulu datanya, terus nerima paraemter error, jaga jaga klo error
        ResponseData responseData = new ResponseData<>(); // ngatur format json nya
        responseData.setStatus(true); // klo gini, yang ke return dalaah data yang berhasil ke simpan
        responseData.setPayload(productService.save(product));
        return ResponseEntity.ok(responseData);

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


