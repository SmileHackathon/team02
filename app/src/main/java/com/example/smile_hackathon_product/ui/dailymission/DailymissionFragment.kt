package com.example.smile_hackathon_product.ui.dailymission

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.smile_hackathon_product.R
import com.example.smile_hackathon_product.ui.dailymission.DailymissionViewModel

class DailymissionFragment : Fragment() {
    private lateinit var dailymissionViewModel: DailymissionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dailymissionViewModel =
            ViewModelProvider(this).get(DailymissionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dailymission, container, false)
        val textView: TextView = root.findViewById(R.id.text_dailymission)
        dailymissionViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}