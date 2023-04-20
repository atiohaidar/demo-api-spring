package com.belajar;

import org.springframework.stereotype.Component;

@Component //klo kek gini berarti class ini udah ke daftar ke container dan kelas ini bakal dibikin objetnya otomatis sama sprign nya
public class ClassKecil {
    public void haloGes(){
        System.out.println("halau semua, ini dari kelas kecil");
    }
}
