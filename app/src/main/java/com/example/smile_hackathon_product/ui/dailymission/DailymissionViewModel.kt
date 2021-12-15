package com.example.smile_hackathon_product.ui.dailymission

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DailymissionViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is dailymission Fragment"
    }
    val text: LiveData<String> = _text
}