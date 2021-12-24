package com.holylox.fragmentornek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.holylox.fragmentornek.databinding.FragmentSonucBinding


class SonucFragment : Fragment() {

    private var _binding:FragmentSonucBinding? = null
    private val binding get() = _binding!!

    private val args:SonucFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSonucBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sonuc = args.sonuc
        if(sonuc == "KAZANDIN")
        {
            binding.sonucText.text = "KAZANDIN"
            binding.sonucImage.setImageResource(R.drawable.kazandin)
        }
        else
        {
            binding.sonucText.text = "KAYBETTİN"
            binding.sonucImage.setImageResource(R.drawable.kaybettin)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}