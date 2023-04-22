package com.belajar.models.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.belajar.models.entities.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    // product iru nama entiti class nya
    // long itu tipe primary key nya

    // klo udah nge etend ke crudrepo itu udah otomatis punya fugnsi untuk crud, walaupun kita ga bikin
    
    List<Product> findByNameContains(String name); // ini kita bikin fungsi quyery otomatis dibikinin dari sana
    // jadi kita ga harus nulis querynnya secara eksplisit
}
