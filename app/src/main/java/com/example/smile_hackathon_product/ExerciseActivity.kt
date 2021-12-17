package com.example.smile_hackathon_product

import android.content.Context
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


        val sharedPreference = getSharedPreferences(myApp.preferencePath, Context.MODE_PRIVATE)
        // 完了ボタンが押されたときの処理
        finishedExerciseButton.setOnClickListener{
            if (getExerciseName == "squat") {
                myApp.exercisePlayMap["squat"] = 1
                val editor = sharedPreference.edit()
                editor.putInt("Played_squat", 1)
                editor.apply()
            }
            if (getExerciseName == "walking") {
                myApp.exercisePlayMap["walking"] = 1
                val editor = sharedPreference.edit()
                editor.putInt("Played_walking", 1)
                editor.apply()
            }
            if (getExerciseName == "running") {
                myApp.exercisePlayMap["running"] = 1
                val editor = sharedPreference.edit()
                editor.putInt("Played_running", 1)
                editor.apply()
            }
            if (getExerciseName == "plank") {
                myApp.exercisePlayMap["plank"] = 1
                val editor = sharedPreference.edit()
                editor.putInt("Played_plank", 1)
                editor.apply()
            }
            if (getExerciseName == "fukkin") {
                myApp.exercisePlayMap["fukkin"] = 1
                val editor = sharedPreference.edit()
                editor.putInt("Played_fukking", 1)
                editor.apply()
            }
            if (getExerciseName == "haikinn") {
                myApp.exercisePlayMap["haikinn"] = 1
                val editor = sharedPreference.edit()
                editor.putInt("Played_haikinn", 1)
                editor.apply()
            }
            if (getExerciseName == "udetate") {
                myApp.exercisePlayMap["udetate"] = 1
                val editor = sharedPreference.edit()
                editor.putInt("Played_udetate", 1)
                editor.apply()
            }
            if (getExerciseName == "momoage") {
                myApp.exercisePlayMap["momoage"] = 1
                val editor = sharedPreference.edit()
                editor.putInt("Played_momoage", 1)
                editor.apply()
            }
            var intent = Intent(this, ExerciseResultActivity::class.java)
            intent.putExtra("EXERCISE_EXP", exerciseExp)
            myApp.gatchaPoint += getPoint
            // ガチャポイントを保存
            val editor = getSharedPreferences(myApp.preferencePath, Context.MODE_PRIVATE).edit()
            editor.putInt(myApp.gatchaPointStr, myApp.gatchaPoint)
            editor.apply()

            startActivity(intent)
            finish()
        }

        // 戻るボタンが押されたときの処理
        backButton.setOnClickListener{
            finish()
        }

    }
}

