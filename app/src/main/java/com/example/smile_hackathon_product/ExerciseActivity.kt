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

        // Homeで押されたボタンの運動を受け取る
        exerciseName.text = intent.getStringExtra("EXERCISE_NAME")
        exerciseTime.text = intent.getStringExtra("EXERCISE_TIME")
        val exerciseExp = intent.getIntExtra("EXERCISE_EXP", 0)

        // 完了ボタンが押されたときの処理
        finishedExerciseButton.setOnClickListener{
            var intent = Intent(this, ExerciseResultActivity::class.java)
            intent.putExtra("EXERCISE_EXP", exerciseExp)
            startActivity(intent)
            finish()
        }

    }
}