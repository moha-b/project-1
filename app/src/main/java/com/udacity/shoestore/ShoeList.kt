package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeDesignBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel

class ShoeList : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.fab.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_shoeList_to_shoeDetail) }

        }
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.showProduct.addView(addProduct())

        return binding.root
    }

    private fun addProduct(): View {

        val bind:ShoeDesignBinding = ShoeDesignBinding.inflate(LayoutInflater.from(requireContext()))
            //bind.shoe = viewModel // error couldn't make a guess for com.udacity.shoestore.models.shoeViewModel
            //bind.shoe = Shoe("","","","")
//            viewModel.shoelist.observe(requireActivity(), Observer {
//                bind.productName.text = Shoe?.name
//                bind.productSize.text = Shoe?.size
//                bind.productCompany.text = Shoe?.company
//                bind.productDescription.text = Shoe?.description
//            })
        viewModel.shoelist.observe(viewLifecycleOwner, Observer {

        })
        return bind.root
   }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        requireView().findNavController().navigate(ShoeListDirections.actionShoeListPopIncludingLogin())
        return true
    }
}

