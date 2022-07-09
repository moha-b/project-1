package com.udacity.shoestore

import android.os.Bundle
import android.util.Size
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.shoeViewModel


class ShoeDetail : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: shoeViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentShoeDetailBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(shoeViewModel::class.java)

        addShoe()
        addCompany()
        addSize()
        addDescription()


//        name.observe(viewLifecycleOwner, Observer { newName ->
//            binding.shoeName.setText(newName.toString())
//        })
//
//        company.observe(viewLifecycleOwner, Observer { newCompany ->
//            binding.company.setText(newCompany.toString())
//        })
//
//        size.observe(viewLifecycleOwner, Observer { newSize ->
//            binding.size.setText(newSize.toString())
//        })
//
//        description.observe(viewLifecycleOwner, Observer { newDescription ->
//            binding.Description.setText(newDescription.toString())
//        })

        binding.save.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_shoeDetail_to_shoeList) }
        }

        return binding.root
    }

    private fun addShoe(){
        var shoeName = binding.shoeName.text
            viewModel.name.value = shoeName.toString()
    }
    private fun addCompany(){
        var shoeCompany = binding.company.text
        viewModel.company.value = shoeCompany.toString()
    }
    private fun addSize(){
        var shoeSize = binding.size.text
        viewModel.size.value = shoeSize.toString()
    }
    private fun addDescription(){
        var shoeDescription = binding.Description.text
        viewModel.description.value = shoeDescription.toString()
    }
}