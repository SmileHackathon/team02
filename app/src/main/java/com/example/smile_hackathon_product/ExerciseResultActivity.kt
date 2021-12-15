package com.example.smile_hackathon_product

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExerciseResultActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_result)

        // Viewの取得
        val exerciseExp : TextView = findViewById(R.id.exercise_exp)
        val exerciseResultFinishButton : Button = findViewById(R.id.exercise_result_finish_button)

        // 獲得した経験値の表示
        exerciseExp.text = intent.getIntExtra("EXERCISE_EXP",0).toString() + "経験値を獲得しました！"

        // ホームに戻るボタン
        exerciseResultFinishButton.setOnClickListener{
            finish()
        }

    }
}