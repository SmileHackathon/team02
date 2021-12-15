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

        //スクワットボタン押下時の動作
        squat.setOnClickListener{
            // 1) 画面遷移
            var intent = Intent(activity, ExerciseActivity::class.java)

            // 2) 運動の名前、運動量を渡す
            intent.putExtra("EXERCISE_NAME", "スクワット")
            intent.putExtra("EXERCISE_EXP", 20)
            intent.putExtra("EXERCISE_TIME", "20回")

            startActivity(intent)
        }

        //ウォーキングボタン押下時の動作
        walking.setOnClickListener{
            // 1) 画面遷移
            var intent = Intent(activity, ExerciseActivity::class.java)

            // 2) 運動の名前、運動量を渡す
            intent.putExtra("EXERCISE_NAME", "ウォーキング")
            intent.putExtra("EXERCISE_EXP", 20)
            intent.putExtra("EXERCISE_TIME", "20分")

            startActivity(intent)
        }

        //ランニングボタン押下時の動作
        running.setOnClickListener{
            // 1) 画面遷移
            var intent = Intent(activity, ExerciseActivity::class.java)

            // 2) 運動の名前、運動量を渡す
            intent.putExtra("EXERCISE_NAME", "ランニング")
            intent.putExtra("EXERCISE_EXP", 20)
            intent.putExtra("EXERCISE_TIME", "10分")

            startActivity(intent)
        }

        //プランクボタン押下時の動作
        plank.setOnClickListener{
            // 1) 画面遷移
            var intent = Intent(activity, ExerciseActivity::class.java)

            // 2) 運動の名前、運動量を渡す
            intent.putExtra("EXERCISE_NAME", "プランク")
            intent.putExtra("EXERCISE_EXP", 20)
            intent.putExtra("EXERCISE_TIME", "1分")

            startActivity(intent)
        }

        //腹筋ボタン押下時の動作
        fukkin.setOnClickListener{
            // 1) 画面遷移
            var intent = Intent(activity, ExerciseActivity::class.java)

            // 2) 運動の名前、運動量を渡す
            intent.putExtra("EXERCISE_NAME", "腹筋")
            intent.putExtra("EXERCISE_EXP", 20)
            intent.putExtra("EXERCISE_TIME", "20回")

            startActivity(intent)
        }

        //背筋ボタン押下時の動作
        haikinn.setOnClickListener{
            // 1) 画面遷移
            var intent = Intent(activity, ExerciseActivity::class.java)

            // 2) 運動の名前、運動量を渡す
            intent.putExtra("EXERCISE_NAME", "背筋")
            intent.putExtra("EXERCISE_EXP", 20)
            intent.putExtra("EXERCISE_TIME", "20回")

            startActivity(intent)
        }

        //腕立て伏せボタン押下時の動作
        udetate.setOnClickListener{
            // 1) 画面遷移
            var intent = Intent(activity, ExerciseActivity::class.java)

            // 2) 運動の名前、運動量を渡す
            intent.putExtra("EXERCISE_NAME", "腕立て伏せ")
            intent.putExtra("EXERCISE_EXP", 20)
            intent.putExtra("EXERCISE_TIME", "10回")

            startActivity(intent)
        }

        return root
    }
}