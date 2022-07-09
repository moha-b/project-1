package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.shoeViewModel

class ShoeList : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: shoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentShoeListBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(shoeViewModel::class.java)

        binding.fab.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_shoeList_to_shoeDetail) }
        }


        viewModel.name.observe(viewLifecycleOwner, Observer { newName ->
            binding.name.text = newName.toString()
        })

        viewModel.company.observe(viewLifecycleOwner, Observer { newCompany ->
            binding.company.text = newCompany.toString()
        })

        viewModel.size.observe(viewLifecycleOwner, Observer { newSize ->
            binding.size.text = newSize.toString()
        })

        viewModel.description.observe(viewLifecycleOwner, Observer { newDescription ->
            binding.Description.text = newDescription.toString()
        })

        return binding.root
    }


}