package com.belajar;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
/*Constructor based injection
 * jadi ini klo misal ClassKecil nya ga kedaftar, bakal error. jadi harus ke daftar dua duannya
 */


@Component // ini tuh supaya kelas ini ke daftar di container nya, jadi kelas ini objennya otomatis dibikin oleh spring
// klo ga di bikin anotate kek gini, ga bakala di bikin objetnya sama sprign nya
// karena otomatis ke create objectnya, maka constractor nya itu otomatis jalan juga
public class ClassBesar {
    ClassKecil kelasKecil;

    public ClassBesar (ClassKecil kelasKecil){
        this.kelasKecil = kelasKecil;

    }
    @PostConstruct // ini anotateyang ngasih tau klo fung si ini otomatis di jjalanin setelah constructornnya di panggil
    public void sayHallo(){
        System.out.println("ini kelas besar");
        kelasKecil.haloGes();
    }
}
