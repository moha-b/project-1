package com.udacity.shoestore.models

import android.util.EventLogTags
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class shoeViewModel: ViewModel() {

    var _name = ""
    var _company = ""
    var _size = ""
    var _description = ""

    private var _shoe:MutableLiveData<List<Shoe>> = MutableLiveData(listOf())

    fun addNewShoe(name: String, size: String, company: String, description: String) {
        val item = Shoe(name, size, company, description)
        _shoe.value = _shoe.value?.plus(item) ?: listOf(item)
    }
    var shoe:LiveData<List<Shoe>> = _shoe

}