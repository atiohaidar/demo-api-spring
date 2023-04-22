package com.belajar.services;
// ini tuh untuk bisnis proses dari aplikasinya,\
// misal transfer, kan gne cek dulu rekeningnya ada atau engga, nah yang nge handle itu disini

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajar.models.entities.Product;
import com.belajar.models.repos.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product findOne(Long id){
        Optional<Product> temp = productRepo.findById(id); // ini kita masukin data yang dicarinnya ke variabel temp
        // dan ini optional, temp nya boleh ada boleh engga, klo ternnyata id nya ga ketemu, maaka ispresent nya false
        
        if (!temp.isPresent()){
            return null;
        }
        return temp.get();
        
    }
    public Iterable<Product> findAll(){
        return productRepo.findAll();
    }
    public void removeOn(Long id){
        productRepo.deleteById(id);

    }
    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }

}
