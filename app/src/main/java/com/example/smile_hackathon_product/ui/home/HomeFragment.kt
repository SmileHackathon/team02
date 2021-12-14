package com.example.smile_hackathon_product.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.smile_hackathon_product.R
import com.example.smile_hackathon_product.ExerciseActivity

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


        //Viewの取得
        var squat: ImageButton = root.findViewById(R.id.squat)

        //ボタン押下時の動作
        squat.setOnClickListener{
            // 1) 画面遷移
            var intent = Intent(activity, ExerciseActivity::class.java)

            // 2) 運動の名前、運動量を渡す
            intent.putExtra("EXERCISE_NAME", "スクワット")
            intent.putExtra("EXERCISE_EXP", 20)
            intent.putExtra("EXERCISE_TIME", "20回")

            startActivity(intent)
        }

        return root
    }
}