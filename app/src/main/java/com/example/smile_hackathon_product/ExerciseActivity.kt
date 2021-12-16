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
        exerciseName.text = myApp.exerciseNameMap[intent.getStringExtra("EXERCISE_NAME")]
        exerciseTime.text = myApp.exerciseTimeMap[intent.getStringExtra("EXERCISE_NAME")]
        val exerciseExp = myApp.exerciseExpMap[intent.getStringExtra("EXERCISE_NAME")]
        val getPoint = intent.getIntExtra("POINT", 0)

        // 受けとった運動ごとに表示を変える

        // 完了ボタンが押されたときの処理
        finishedExerciseButton.setOnClickListener{
            var intent = Intent(this, ExerciseResultActivity::class.java)
            intent.putExtra("EXERCISE_EXP", exerciseExp)
            myApp.gatchaPoint += getPoint
            startActivity(intent)
            finish()
        }

        // 戻るボタンが押されたときの処理
        backButton.setOnClickListener{
            finish()
        }

    }
}