package com.example.smile_hackathon_product.ui.home

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.smile_hackathon_product.ExerciseActivity
import com.example.smile_hackathon_product.MyApplication
import com.example.smile_hackathon_product.R

class Home2Fragment : Fragment() {

    private lateinit var home2ViewModel: Home2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        home2ViewModel =
            ViewModelProvider(this).get(Home2ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home2, container, false)

        // Viewの取得
        var haikinn: ImageButton = root.findViewById(R.id.haikinn)
        var momoage: ImageButton = root.findViewById(R.id.momoage)
        var prevButton : Button = root.findViewById(R.id.prev_button)

        //instance呼び出し
        val myApp = MyApplication.getInstance()

        if (myApp.exerciseMap["haikinn"] == 1) {
            haikinn.setImageResource(R.drawable.haikinn)
            //背筋ボタン押下時の動作
            haikinn.setOnClickListener {
                // 1) 画面遷移
                var intent = Intent(activity, ExerciseActivity::class.java)

                // 2) 運動の名前、運動量を渡す
                intent.putExtra("EXERCISE_NAME", "haikinn")

                startActivity(intent)
            }
        }

        if (myApp.exerciseMap["momoage"] == 1) {
            momoage.setImageResource(R.drawable.momoage)
            //モモ上げボタン押下時の動作
            momoage.setOnClickListener {
                // 1) 画面遷移
                var intent = Intent(activity, ExerciseActivity::class.java)

                // 2) 運動の名前、運動量を渡す
                intent.putExtra("EXERCISE_NAME", "momoage")

                startActivity(intent)
            }
        }

        // 戻るボタン
        prevButton.setOnClickListener{
            findNavController().navigate(R.id.action_back_to_firstFragment)
        }

        return root
    }

}