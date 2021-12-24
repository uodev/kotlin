package com.holylox.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.holylox.layouts.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    binding.hesaplaButton.setOnClickListener {
        bahsisHesapla()
    }
    }

    fun bahsisHesapla() {
        val hizmetBedeliString = binding.hizmetBedeliEditText.text.toString()

        if (hizmetBedeliString.isNullOrEmpty()) {
            Toast.makeText(this, "Lütfen bir hizmet bedeli giriniz!", Toast.LENGTH_SHORT).show()
        } else {
            val hizmetBedeliTutar = hizmetBedeliString.toDouble()

            val secilenRadioButon = binding.bahsisSecenekRadioGroup.checkedRadioButtonId

            val bahsisYuzdesi = when (secilenRadioButon) {
                R.id.yuzdeYirmiRadioButton -> 0.20
                R.id.yuzdeOnSekizRadioButton -> 0.18
                else -> 0.15
            }

            var bahsis = bahsisYuzdesi * hizmetBedeliTutar

            val yukariYuvarla = binding.bahsisYuvarlaSwitch.isChecked

            if (yukariYuvarla) {
                bahsis = kotlin.math.ceil(bahsis)
            }

            val formatlananBahsis =
                NumberFormat.getCurrencyInstance(Locale("tr", "TR")).format(bahsis)
            binding.bahsisTutarTextView.text = getString(R.string.bahsisTutari, formatlananBahsis)
        }
    }
    }
