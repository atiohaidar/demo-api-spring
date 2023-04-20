package com.belajar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
/* Field Injection
 * jadi ini klo misal ClassKecil nya ga kedaftar di conteiner, bisa ga maslaah, masih bisa
 * tapi kita ga perlu nge bikin method atau constructor eksplisit buat bikin object nya
 */


 @Component // tetep dijadii n component supaya kedaftar dan otomatis kebikin objecfctnya sma spring nya
// ini ga perlu di kasih constructor(karena setter based)
public class ClassBesar {

    @Autowired(required = false) // jadi ini optional.
    ClassKecil kelasKecil;
    


    @PostConstruct // ini anotateyang ngasih tau klo fung si ini otomatis di jjalanin setelah constructornnya di panggil
    public void sayHallo(){

        System.out.println("ini kelas besar");
        if (kelasKecil == null){
                System.out.println("Kelas Kecilnnya ga terdeteksi");
        }else{

            kelasKecil.haloGes(); // ini kiga ga manggil eksplisit, sebelumnya kita ga masukin nilai kelas kecil
            // tapi kok bisa tetep masuk klo di kelaskecilnnya di kasih anotate component?
            // karena kelas kecil udah kedaftar dan properti kelaskecil udah dikasih anotate autowired
        }
    }
}
