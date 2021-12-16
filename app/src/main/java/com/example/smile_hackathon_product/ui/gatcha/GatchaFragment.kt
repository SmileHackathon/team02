package com.example.smile_hackathon_product.ui.gatcha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.smile_hackathon_product.R

class GatchaFragment : Fragment() {

    private lateinit var gatchaViewModel: GatchaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gatchaViewModel =
            ViewModelProvider(this).get(GatchaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gatcha, container, false)

        var gatchaButton : Button = root.findViewById(R.id.gatcha_button)

        return root
    }
}