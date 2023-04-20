package com.belajar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
/* Setter based injection
 * jadi ini klo misal ClassKecil nya ga kedaftar di conteiner, bisa ga maslaah, masih bisa
 */


 @Component // tetep dijadii n component supaya kedaftar dan otomatis kebikin objecfctnya sma spring nya
// ini ga perlu di kasih constructor(karena setter based)
public class ClassBesar {
    ClassKecil kelasKecil;
    
    @Autowired(required = false) // jadi ini optional.
    // yang aku pahami, ini kita coba nyari object kelaskecil di container, tapi klo ga ada ga apa apa.
    // tapi klo misal ada di container, maka dimasukin ke sini, klo ga ada ga apa apa, karena ga required juga
    public void setKelasKecil(ClassKecil kelasKecil){// jadi masukinnya make setter
        this.kelasKecil = kelasKecil;

    }

    @PostConstruct // ini anotateyang ngasih tau klo fung si ini otomatis di jjalanin setelah constructornnya di panggil
    public void sayHallo(){

        System.out.println("ini kelas besar");
        if (kelasKecil == null){
                System.out.println("Kelas Kecilnnya ga terdeteksi");
        }else{

            kelasKecil.haloGes();
        }
    }
}
