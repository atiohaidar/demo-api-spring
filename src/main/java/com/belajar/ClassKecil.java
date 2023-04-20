package com.belajar;

import org.springframework.stereotype.Component;


 // klo ga ada anotate component, maka ga masuk ke container
public class ClassKecil {
    public void haloGes(){
        System.out.println("halau semua, ini dari kelas kecil");
    }
}
