package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeList : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentShoeListBinding.inflate(inflater,container,false)





        return binding.root
    }


}