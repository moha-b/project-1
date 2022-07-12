package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R.layout.shoe_design
import com.udacity.shoestore.databinding.FragmentShoeListBinding
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
        val view: View = LayoutInflater.from(context).inflate(R.layout.shoe_design,null,false)

        viewModel.name.observe(viewLifecycleOwner, Observer { newName ->
            view.product_name.text = newName.toString()
        })

        viewModel.company.observe(viewLifecycleOwner, Observer { newCompany ->
            view.product_company.text = newCompany.toString()
        })

        viewModel.size.observe(viewLifecycleOwner, Observer { newSize ->
            view.product_description.text = newSize.toString()
        })

        viewModel.description.observe(viewLifecycleOwner, Observer { newDescription ->
            view.product_size.text = newDescription.toString()
        })
        return view
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

