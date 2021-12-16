package com.example.smile_hackathon_product.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.smile_hackathon_product.R
import com.example.smile_hackathon_product.ExerciseActivity
import com.example.smile_hackathon_product.MyApplication

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


        //Viewの取得
        var squat: ImageButton = root.findViewById(R.id.squat)
        var walking: ImageButton = root.findViewById(R.id.walking)
        var running: ImageButton = root.findViewById(R.id.running)
        var plank: ImageButton = root.findViewById(R.id.plank)
        var fukkin: ImageButton = root.findViewById(R.id.fukkin)
        var haikinn: ImageButton = root.findViewById(R.id.haikinn)
        var udetate: ImageButton = root.findViewById(R.id.udetate)


        //instance呼び出し
        val myApp = MyApplication.getInstance()

        if (myApp.exerciseMap["squat"] == 1) {
            squat.setImageResource(R.drawable.squat)
            //スクワットボタン押下時の動作
            squat.setOnClickListener{
                // 1) 画面遷移
                var intent = Intent(activity, ExerciseActivity::class.java)

                // 2) 運動の名前、運動量を渡す
                intent.putExtra("EXERCISE_NAME", "squat")

                startActivity(intent)
            }
        }


        if (myApp.exerciseMap["walking"] == 1) {
            walking.setImageResource(R.drawable.walking)
            //ウォーキングボタン押下時の動作
            walking.setOnClickListener {
                // 1) 画面遷移
                var intent = Intent(activity, ExerciseActivity::class.java)

                // 2) 運動の名前、運動量を渡す
                intent.putExtra("EXERCISE_NAME", "walking")

                startActivity(intent)
            }
        }

        if (myApp.exerciseMap["running"] == 1) {
            running.setImageResource(R.drawable.running)
            //ランニングボタン押下時の動作
            running.setOnClickListener {
                // 1) 画面遷移
                var intent = Intent(activity, ExerciseActivity::class.java)

                // 2) 運動の名前、運動量を渡す
                intent.putExtra("EXERCISE_NAME", "running")

                startActivity(intent)
            }
        }

        if (myApp.exerciseMap["plank"] == 1) {
            plank.setImageResource(R.drawable.plank)
            //プランクボタン押下時の動作
            plank.setOnClickListener {
                // 1) 画面遷移
                var intent = Intent(activity, ExerciseActivity::class.java)

                // 2) 運動の名前、運動量を渡す
                intent.putExtra("EXERCISE_NAME", "plank")

                startActivity(intent)
            }
        }

        if (myApp.exerciseMap["fukkin"] == 1) {
            fukkin.setImageResource(R.drawable.fukkin)
            //腹筋ボタン押下時の動作
            fukkin.setOnClickListener {
                // 1) 画面遷移
                var intent = Intent(activity, ExerciseActivity::class.java)

                // 2) 運動の名前、運動量を渡す
                intent.putExtra("EXERCISE_NAME", "fukkin")

                startActivity(intent)
            }
        }

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

        if (myApp.exerciseMap["udetate"] == 1) {
            udetate.setImageResource(R.drawable.udetate)
            //腕立て伏せボタン押下時の動作
            udetate.setOnClickListener {
                // 1) 画面遷移
                var intent = Intent(activity, ExerciseActivity::class.java)

                // 2) 運動の名前、運動量を渡す
                intent.putExtra("EXERCISE_NAME", "udetate")

                startActivity(intent)
            }
        }

        return root
    }
}