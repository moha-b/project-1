package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeDesignBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.shoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.*
import kotlinx.android.synthetic.main.shoe_design.view.*

class ShoeList : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: shoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.fab.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_shoeList_to_shoeDetail) }

        }
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(requireActivity()).get(shoeViewModel::class.java)
        //binding.showProduct.addView(addProduct())

        return binding.root
    }

    private fun addProduct(): View {

        val bind:ShoeDesignBinding = DataBindingUtil.setContentView(requireActivity(),R.layout.shoe_design)
        bind.apply {
            //bind.shoe = viewModel // error couldn't make a guess for com.udacity.shoestore.models.shoeViewModel
            viewModel.shoelist.observe(viewLifecycleOwner, Observer {
                bind.productName.text = shoe.name
                bind.productSize.text = shoe.size
                bind.productCompany.text = shoe.company
                bind.productDescription.text = shoe.description
        })
            invalidateAll()
        }
        return bind.root
   }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,view!!.findNavController())||
        super.onOptionsItemSelected(item)
    }
}

