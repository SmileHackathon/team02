package com.example.smile_hackathon_product.ui.dailymission

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
import com.example.smile_hackathon_product.ui.dailymission.DailymissionViewModel
import android.widget.LinearLayout.*
import android.graphics.Color
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import com.example.smile_hackathon_product.ExerciseActivity
import com.example.smile_hackathon_product.MyApplication
import org.w3c.dom.Text

class DailymissionFragment : Fragment() {
    private lateinit var dailymissionViewModel: DailymissionViewModel

    var dailyMissionList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dailymissionViewModel =
            ViewModelProvider(this).get(DailymissionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dailymission, container, false)

        // Viewの取得
        val daily1 : ImageButton = root.findViewById(R.id.daily1)
        val daily2 : ImageButton = root.findViewById(R.id.daily2)
        val daily3 : ImageButton = root.findViewById(R.id.daily3)
        val tvDaily1 : TextView = root.findViewById(R.id.tv_daily1)
        val tvDaily2 : TextView = root.findViewById(R.id.tv_daily2)
        val tvDaily3 : TextView = root.findViewById(R.id.tv_daily3)

        //instance呼び出し
        val myApp = MyApplication.getInstance()
        val existListSize = myApp.existList.size

        // 持っている運動のリストから、ランダムでデイリーミッションを選ぶ
        if (myApp.existList.size <= 3){
            dailyMissionList += myApp.existList
        } else {
            dailyMissionList += myApp.existList
            for (i in 0..(existListSize-4)){
                dailyMissionList -= dailyMissionList[(0 until dailyMissionList.size).random()]
            }
        }

        // ボタン1の画像
        if (dailyMissionList[0] == "squat"){
            daily1.setImageResource(R.drawable.squat)
        }
        if (dailyMissionList[0] == "walking"){
            daily1.setImageResource(R.drawable.walking)
        }
        if (dailyMissionList[0] == "running"){
            daily1.setImageResource(R.drawable.running)
        }
        if (dailyMissionList[0] == "plank"){
            daily1.setImageResource(R.drawable.plank)
        }
        if (dailyMissionList[0] == "fukkin"){
            daily1.setImageResource(R.drawable.fukkin)
        }
        if (dailyMissionList[0] == "haikinn"){
            daily1.setImageResource(R.drawable.haikinn)
        }
        if (dailyMissionList[0] == "udetate"){
            daily1.setImageResource(R.drawable.udetate)
        }
        if (dailyMissionList[0] == "momoage"){
            daily1.setImageResource(R.drawable.momoage)
        }

        // デイリーミッション未達成時
        if (myApp.exercisePlayMap[dailyMissionList[0]] == 0) {
            // text
            tvDaily1.text = "ミッション\n" +
                    "　未達成"
            // ボタン1が押されたときの処理
            daily1.setOnClickListener {
                // 画面遷移
                val intent = Intent(activity, ExerciseActivity::class.java)

                // 運動名を送る
                intent.putExtra("EXERCISE_NAME", dailyMissionList[0])
                intent.putExtra("POINT", 10)

                startActivity(intent)
            }
        }
        // ミッション達成時
        else {
            tvDaily1.text = "ミッション\n" +
                    "　達成！"
        }

        // ボタン2の画像
        if (dailyMissionList[1] == "squat"){
            daily2.setImageResource(R.drawable.squat)
        }
        if (dailyMissionList[1] == "walking"){
            daily2.setImageResource(R.drawable.walking)
        }
        if (dailyMissionList[1] == "running"){
            daily2.setImageResource(R.drawable.running)
        }
        if (dailyMissionList[1] == "plank"){
            daily2.setImageResource(R.drawable.plank)
        }
        if (dailyMissionList[1] == "fukkin"){
            daily2.setImageResource(R.drawable.fukkin)
        }
        if (dailyMissionList[1] == "haikinn"){
            daily2.setImageResource(R.drawable.haikinn)
        }
        if (dailyMissionList[1] == "udetate"){
            daily2.setImageResource(R.drawable.udetate)
        }
        if (dailyMissionList[1] == "momoage"){
            daily2.setImageResource(R.drawable.momoage)
        }

        // ミッション未達成時
        if (myApp.exercisePlayMap[dailyMissionList[1]] == 0) {
            // text
            tvDaily2.text = "ミッション\n" +
                    "　未達成"
            // ボタン2が押されたときの処理
            daily2.setOnClickListener {
                // 画面遷移
                val intent = Intent(activity, ExerciseActivity::class.java)

                // 運動名を送る
                intent.putExtra("EXERCISE_NAME", dailyMissionList[1])
                intent.putExtra("POINT", 10)

                startActivity(intent)
            }
        }
        // ミッション達成時
        else{
            tvDaily2.text = "ミッション\n" +
                    "　達成!"
        }

        if (dailyMissionList.size >= 3){

            // ボタン3の画像
            if (dailyMissionList[2] == "squat"){
                daily3.setImageResource(R.drawable.squat)
            }
            if (dailyMissionList[2] == "walking"){
                daily3.setImageResource(R.drawable.walking)
            }
            if (dailyMissionList[2] == "running"){
                daily3.setImageResource(R.drawable.running)
            }
            if (dailyMissionList[2] == "plank"){
                daily3.setImageResource(R.drawable.plank)
            }
            if (dailyMissionList[2] == "fukkin"){
                daily3.setImageResource(R.drawable.fukkin)
            }
            if (dailyMissionList[2] == "haikinn"){
                daily3.setImageResource(R.drawable.haikinn)
            }
            if (dailyMissionList[2] == "udetate"){
                daily3.setImageResource(R.drawable.udetate)
            }
            if (dailyMissionList[2] == "momoage"){
                daily3.setImageResource(R.drawable.momoage)
            }

            // ミッション未達成時
            if (myApp.exercisePlayMap[dailyMissionList[2]] == 0) {
                // text
                tvDaily3.text = "ミッション\n" +
                        "　未達成"
                // ボタン3が押されたときの処理
                daily3.setOnClickListener {
                    // 画面遷移
                    val intent = Intent(activity, ExerciseActivity::class.java)

                    // 運動名を送る
                    intent.putExtra("EXERCISE_NAME", dailyMissionList[2])
                    intent.putExtra("POINT", 10)

                    startActivity(intent)
                }
            }
            // ミッション達成時
            else {
                tvDaily3.text = "ミッション\n" +
                        "　達成！"
            }
        }


        return root
    }

}