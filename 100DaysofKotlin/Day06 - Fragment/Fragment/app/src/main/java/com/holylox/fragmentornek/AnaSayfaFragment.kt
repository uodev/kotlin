package com.holylox.fragmentornek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.holylox.fragmentornek.databinding.FragmentAnaSayfaBinding

class AnaSayfaFragment : Fragment() {

    private var _binding:FragmentAnaSayfaBinding? = null
    private val binding get() =_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnaSayfaBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.oynaBTN.setOnClickListener {
            findNavController().navigate(R.id.anaSayfatoTahmin)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}