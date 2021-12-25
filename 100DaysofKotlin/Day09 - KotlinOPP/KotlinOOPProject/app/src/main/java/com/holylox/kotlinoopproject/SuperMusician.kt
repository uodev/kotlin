package com.holylox.kotlinoopproject

class SuperMusician(name: String, instrument: String, age: Int) : Musician(name, instrument, age) {
    fun sing()
    {
        println("boulevard of broken dreams")
    }
}