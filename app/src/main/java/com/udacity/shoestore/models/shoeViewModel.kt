package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class shoeViewModel: ViewModel() {

    var name = MutableLiveData<String>()
    var company = MutableLiveData<String>()
    var size = MutableLiveData<String>()
    var description = MutableLiveData<String>()
    override fun onCleared() {
        super.onCleared()
    }
}