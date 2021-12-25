package com.holylox.kotlinrunnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.holylox.kotlinrunnables.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var time = 0
    //Runnable bir interface(arayüz) %100 soyut bir sınıf
    var runnable:Runnable = Runnable{ }

    var handler:Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun start(view: View)
    {
        time=0
        runnable = object : Runnable {
            override fun run() { //arkaplanda periyot olarak çalıştırılacak
                time++
                binding.counterTextView.text = "Time: $time"

                handler.postDelayed(this,1000)
            }

        }
        handler.post(runnable)
    }

    fun stop(view:View)
    {
        handler.removeCallbacks(runnable)
        time = 0
        binding.counterTextView.text="Time: $time"
    }
}