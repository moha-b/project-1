package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeDesignBinding
import com.udacity.shoestore.models.shoeViewModel
import kotlinx.android.synthetic.main.shoe_design.view.*

class ShoeList : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: shoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentShoeListBinding.inflate(inflater,container,false)

        binding.fab.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_shoeList_to_shoeDetail) }

        }
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(requireActivity()).get(shoeViewModel::class.java)

        return binding.root
    }

    private fun addProduct(): View {

        val bind:ShoeDesignBinding = ShoeDesignBinding.inflate(layoutInflater)
        bind.shoe = viewModel
        viewModel._name.observe(viewLifecycleOwner, Observer { newName ->
            bind.productName.text = newName.toString()
        })

        viewModel._company.observe(viewLifecycleOwner, Observer { newCompany ->
            bind.productCompany.text = newCompany.toString()
        })

        viewModel._size.observe(viewLifecycleOwner, Observer { newSize ->
            bind.productSize.text = newSize.toString()
        })

        viewModel._description.observe(viewLifecycleOwner, Observer { newDescription ->
            bind.productDescription.text = newDescription.toString()
        })
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

