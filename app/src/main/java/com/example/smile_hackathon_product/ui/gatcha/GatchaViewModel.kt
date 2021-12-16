package com.example.smile_hackathon_product.ui.gatcha

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GatchaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Gatcha Fragment"
    }
    val text: LiveData<String> = _text
}