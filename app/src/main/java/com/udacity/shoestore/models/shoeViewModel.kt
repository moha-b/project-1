package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class shoeViewModel: ViewModel() {

   var _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name
    var _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company
    var _size = MutableLiveData<String>()
    val size: LiveData<String>
        get() = _size
    var _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

}