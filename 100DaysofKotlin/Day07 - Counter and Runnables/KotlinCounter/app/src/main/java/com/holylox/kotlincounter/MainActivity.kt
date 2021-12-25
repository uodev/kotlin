package com.holylox.kotlincounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import com.holylox.kotlincounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    fun count(view:View)
    {
        //Abstract -> böyle oluşturulan sınıfları kullanamayız
        //Inheritance
        object : CountDownTimer(10000,1000)
        {
            override fun onTick(p0: Long) {
                binding.counterTextView.text = "Left: ${p0/1000}"
            }

            override fun onFinish() {
                binding.counterTextView.text = "Left: 0"
            }

        }.start()
    }
}