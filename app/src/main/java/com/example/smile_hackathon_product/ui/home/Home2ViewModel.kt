package com.example.smile_hackathon_product.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Home2ViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is home2 Fragment"
    }
    val text: LiveData<String> = _text
}