package com.example.smile_hackathon_product

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ExerciseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        // Viewの取得
        val exerciseName : TextView = findViewById(R.id.exercise_name)
        val exerciseTime : TextView = findViewById(R.id.exercise_time)
        val finishedExerciseButton : Button = findViewById(R.id.finished_exercise_button)
        val backButton : Button = findViewById(R.id.back_button)

        //instance呼び出し
        val myApp = MyApplication.getInstance()

        // Homeで押されたボタンの運動を受け取る
        val getExerciseName = intent.getStringExtra("EXERCISE_NAME")
        exerciseName.text = myApp.exerciseNameMap[intent.getStringExtra("EXERCISE_NAME")]
        exerciseTime.text = myApp.exerciseTimeMap[intent.getStringExtra("EXERCISE_NAME")]
        val exerciseExp = myApp.exerciseExpMap[intent.getStringExtra("EXERCISE_NAME")]
        val getPoint = intent.getIntExtra("POINT", 0)


        // 完了ボタンが押されたときの処理
        finishedExerciseButton.setOnClickListener{
            if (getExerciseName == "squat") {
                myApp.exercisePlayMap["squat"] = 1
            }
            if (getExerciseName == "walking") {
                myApp.exercisePlayMap["walking"] = 1
            }
            if (getExerciseName == "running") {
                myApp.exercisePlayMap["running"] = 1
            }
            if (getExerciseName == "plank") {
                myApp.exercisePlayMap["plank"] = 1
            }
            if (getExerciseName == "fukkin") {
                myApp.exercisePlayMap["fukkin"] = 1
            }
            if (getExerciseName == "haikinn") {
                myApp.exercisePlayMap["haikinn"] = 1
            }
            if (getExerciseName == "udetate") {
                myApp.exercisePlayMap["udetate"] = 1
            }
            if (getExerciseName == "momoage") {
                myApp.exercisePlayMap["momoage"] = 1
            }
            var intent = Intent(this, ExerciseResultActivity::class.java)
            intent.putExtra("EXERCISE_EXP", exerciseExp)
            myApp.gatchaPoint += getPoint
            // ガチャポイントを保存
            myApp.putValue("gatchaPoint", myApp.gatchaPoint)
            startActivity(intent)
            finish()
        }

        // 戻るボタンが押されたときの処理
        backButton.setOnClickListener{
            finish()
        }

    }
}

