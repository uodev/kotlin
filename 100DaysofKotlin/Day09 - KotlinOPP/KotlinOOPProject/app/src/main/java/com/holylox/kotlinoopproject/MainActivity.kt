package com.holylox.kotlinoopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Class(Sınıf) yapısı + constructor
        var myUser = User("Uygar",19)

        println(myUser.age)

        //abstract sınıftan oluşturuldu
        println(myUser.information())

        //encapsulation
        var uygar=Musician("uygar","Guitar",20)
        println(uygar.age)

        println(uygar.returnBandName("uygar"))
        println(uygar.returnBandName("ceylan"))


        //inheritance (miras) -> 10 sınıfımız var ve 7 tanesinde ortak
        //fonksiyon kullanılacak diyelim.
        //bir adet class oluşturup fonksiyonlara buraya koyup
        //daha sonra diğer sınıflara inheritance yapabiliriz!

        var greenDay = SuperMusician("Lars","Drums",48)
        println(greenDay.name)
        greenDay.sing()
        println(greenDay.returnBandName("uygar"))
        //uygar.sing() -> uygar değişkeni sadece musician olduğundan ve
        //içinde sing() fonksiyonu olmadığından bu çalışmaz!


        //polymorphism -> aynı ismi kullanarak farklı işler yapabilme

        //static polymorphism ->aynı sınıf

        //aynı anda fakat farklı sonuç
        var mathematics = Mathematics()
        println(mathematics.sum())
        println(mathematics.sum(3,4))
        println(mathematics.sum(3,4,5))

        //dynamic polymorphism ->farklı sınıflarda
        val animal = Animal()
        animal.sing()

        val barley = Dog()
        barley.test()
        barley.sing()

        //abstract(soyut sınıf oluşturma) & interface(arayüz ve abstractır)
        //soyut sınıf-> bir obje oluşturamayacağımız sınıftır
        //genelde kalıtıma maruz kalması amaçlı yapılır!

        //var myPeople=People() abstract sınıflarının bir objesini oluşturmazsın

        //interface
        var myPiano = Piano()
        myPiano.brand="Yamaha"
        myPiano.digital = false
        println(myPiano.roomName)
        myPiano.info()

        //Lambda expressions -> lambda gösterimleri
        //bir fonksiyonu tek bir satırda yazma şeklinde gösterim
        //input al hemen output ver gibi
        //genelde internet işlemlerinde kullanılır
        //async işlemlerinde kullanılır

        //normal gösterim
        fun printString(myString:String)
        {
            println(myString)
        }

        printString("My test string")

        //lambda gösterimleri
        val testString = {myString:String -> println(myString)}
        testString("My lambda string")

        val multiplyLambda = {a:Int,b:Int-> a*b}
        println(multiplyLambda(4,5))

        val multiplyLambda2 : (Int,Int) -> Int = {a,b-> a*b}
        println(multiplyLambda2(8,5))

        //asynchrnous ->sekronize olmayan

        //callback function, listener function, completion function

        fun downloadMusicians(url:String,completion:(Musician) -> Unit)
        {
            //url -> download
            //data geldi
            val kirkHammet = Musician("Kirk","Guitar",60)
            completion(kirkHammet)
        }
        downloadMusicians("metallica.com/users",{musician->
            println(musician.name)
        })



    }


}