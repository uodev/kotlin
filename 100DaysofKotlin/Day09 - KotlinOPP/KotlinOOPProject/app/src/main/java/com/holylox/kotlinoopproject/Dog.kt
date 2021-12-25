package com.holylox.kotlinoopproject

class Dog:Animal() {
    fun test()
    {
        //inheritance aldığımız sınıfı temsil eder "super"
        //buradaki sing animal sınıfının içindeki sing fonksiyonu
        super.sing()
    }
    //animal sınıfın içindeki sing'i de open yapmamız gerekir override için
     override fun sing()
    {
        println("dog class")
    }

}