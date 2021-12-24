package com.holylox.diceapp

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var baslaTusu:Button=findViewById(R.id.baslangic)
        var zarResim:ImageView=findViewById(R.id.imageView)
        var zarResim2:ImageView=findViewById(R.id.imageView2)

        baslaTusu.setOnClickListener {
            var rastgele = (1..6).random() //sıfır ve 7 arası sayı seçme bir altı dahil
            var rastgele2 = (1..6).random()
            when(rastgele) {
                1-> zarResim.setImageResource(R.drawable.dice_1)
                2-> zarResim.setImageResource(R.drawable.dice_2)
                3-> zarResim.setImageResource(R.drawable.dice_3)
                4-> zarResim.setImageResource(R.drawable.dice_4)
                5-> zarResim.setImageResource(R.drawable.dice_5)
                6-> zarResim.setImageResource(R.drawable.dice_6)
            }
            when(rastgele2) {
                1-> zarResim2.setImageResource(R.drawable.dice_1)
                2-> zarResim2.setImageResource(R.drawable.dice_2)
                3-> zarResim2.setImageResource(R.drawable.dice_3)
                4-> zarResim2.setImageResource(R.drawable.dice_4)
                5-> zarResim2.setImageResource(R.drawable.dice_5)
                6-> zarResim2.setImageResource(R.drawable.dice_6)
            }
            Toast.makeText(this, "zar atıldı", Toast.LENGTH_SHORT).show()

        }


    }
}