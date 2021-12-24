package com.holylox.storingdata

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.holylox.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //SharedPreferences = Genelde küçük veri kaydına yarar /bir anahtar kelime bir değer

        sharedPreferences = getSharedPreferences("com.holylox.storingdata", MODE_PRIVATE)

        val ageFromPreferences = sharedPreferences.getInt("age",0)
        if(ageFromPreferences == 0)
        {
            binding.ageTextView.text = "Your Age: "
        }
        else
        {
            binding.ageTextView.text = "Your Age: $ageFromPreferences"
        }

        binding.saveBTN.setOnClickListener {
            val myAge = binding.ageEditText.text.toString().toIntOrNull()
            if(myAge !=null)
            {
                binding.ageTextView.text = "Your Age: $myAge"
                sharedPreferences.edit().putInt("age",myAge).apply()
            }
        }
    }

    fun delete(view: View)
    {
        sharedPreferences.edit().remove("age").apply()
        binding.ageTextView.text = "Your Age: "
    }
}