package com.holylox.kotlinoopproject

//sınıflar kotlinde default olarak final olarak tanımlanır
//yani başka yerlerde kullanılmaz inheritance yapılmaz!
//başına open koyarak ulaşabiliriz!
open class Musician(name: String, instrument: String, age: Int) {

    //encapsulation ->Sınıf içi hariç hiçbir yerden erişilemez

    var name: String? = name
        private set
        get

    private var instrument:String?= instrument


    var age:Int? = age
        get
        private set

    private val bandName:String = "Green Day"
    //private oluşturduğumuz değerleri bile fonksiyonlar ile ulaşabiliriz!
    //ama değiştirme yetkisi yok!
    fun returnBandName(password:String):String
    {
        if(password == "uygar")
        {
            return bandName
        }
        else
        {
            return "Wrong password!"
        }
    }

}