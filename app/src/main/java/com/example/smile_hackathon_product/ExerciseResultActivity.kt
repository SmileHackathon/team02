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

        //instance呼び出し
        val myApp = MyApplication.getInstance()

        // 獲得した経験値の表示
        var exp = intent.getIntExtra("EXERCISE_EXP",0)
        exerciseExp.text = exp.toString() + "経験値を獲得しました！"

        // 経験値追加
        myApp.exp += exp
        if (myApp.exp >= myApp.neededExp){
            myApp.playerLevel += 1
            myApp.neededExp = myApp.playerLevel * (10 + myApp.playerLevel*10) / 2
            if (myApp.playerLevel%10 == 0) {
                myApp.gatchaPoint += 100
            }else{
                myApp.gatchaPoint += 10
            }
        }


        // ホームに戻るボタン
        exerciseResultFinishButton.setOnClickListener{
            finish()
        }

    }
}