package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class shoeViewModel: ViewModel() {

    private val shoe = mutableListOf(
        Shoe("g1","21","adidas","don't show up don't came now")
    )

    private var _shoelist:MutableLiveData<List<Shoe>> = MutableLiveData(listOf())
    var shoelist:LiveData<List<Shoe>> = _shoelist

    fun addShoe(it:Shoe) {
       shoe.add(it)
        _shoelist.value = shoe
    }
}