package com.udacity.shoestore

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.shoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_list.*
import kotlinx.android.synthetic.main.shoe_design.view.*


class ShoeDetail : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: shoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentShoeDetailBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(requireActivity()).get(shoeViewModel::class.java)


        binding.save.setOnClickListener {
            addData()
            //show_product.addView(addProduct())
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_shoeDetail_to_shoeList) }
        }

        return binding.root
    }

    private fun addData(){
        viewModel.name.value = binding.shoeName.text.toString()
        viewModel.description.value  = binding.shoeDescription.text.toString()
        viewModel.company.value = binding.shoeCompany.text.toString()
        viewModel.size.value = binding.shoeSize.text.toString()
    }

}