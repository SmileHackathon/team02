package com.example.smile_hackathon_product.ui.home

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.smile_hackathon_product.R
import com.example.smile_hackathon_product.ui.dashboard.DashboardFragment
import com.example.smile_hackathon_product.ui.exercise.ExerciseActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        // Viewの取得
        var suquwatto: ImageButton = root.findViewById(R.id.suquwatto)
        suquwatto.setOnClickListener{
            onButtonClick(textView)
        }

        return root
    }

    // ボタン押下時の処理
    public fun onButtonClick(view: TextView){
        Log.i("NewItemFragment","onButtonClick")
        // TextViewを書き換える
        view.text = "BUTTONが押された"
    }
}