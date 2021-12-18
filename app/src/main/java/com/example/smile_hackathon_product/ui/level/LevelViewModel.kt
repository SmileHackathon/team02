package com.example.smile_hackathon_product.ui.level

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LevelViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This level Fragment"
    }
    val text: LiveData<String> = _text
}