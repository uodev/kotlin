package com.holylox.fragmentornek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.holylox.fragmentornek.databinding.FragmentTahminBinding


class TahminFragment : Fragment() {

    private var _binding:FragmentTahminBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTahminBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var hak = 10
        binding.kalanHakTextView.text = "Kalan Hak: $hak"

        val randomSayi = (0..10).random()
        binding.yardimciTextView.text = "Lutfen deger giriniz"

        binding.tahminEtBTN.setOnClickListener {

            if(binding.tahminEditText.text.toString().isEmpty() || binding.tahminEditText.text.toString() == "")
            {
                binding.yardimciTextView.text = "Lutfen deger giriniz"
            }else
            {
                val tahmin = binding.tahminEditText.text.toString().toInt()
                hak--
                binding.kalanHakTextView.text = "Kalan Hak: $hak"
                if(tahmin > randomSayi)
                {
                    binding.yardimciTextView.text = "Yardım: Azalt"
                }
                else if(tahmin < randomSayi)
                {
                    binding.yardimciTextView.text = "Yardım: Arttır"
                }
                else if(tahmin == randomSayi)
                {
                    val gecis = TahminFragmentDirections.tahmintoSonuc("KAZANDIN")
                    findNavController().navigate(gecis)
                }

                if(hak <=0)
                {
                    val gecis = TahminFragmentDirections.tahmintoSonuc("KAYBETTİN")
                    findNavController().navigate(gecis)
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}