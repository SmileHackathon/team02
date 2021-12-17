package com.example.smile_hackathon_product

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExerciseResultActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_result)

        // Viewの取得
        val exerciseExp : TextView = findViewById(R.id.exercise_exp)
        val exerciseResultFinishButton : Button = findViewById(R.id.exercise_result_finish_button)
        val progressBar : ProgressBar = findViewById(R.id.progressbar)
        val tvLevel : TextView = findViewById(R.id.tv_level)
        val tvNeedExp : TextView = findViewById(R.id.tv_need_exp)

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

        // レベルをprogressBarで表示
        progressBar.progress = myApp.exp + myApp.playerLevel * 10 - myApp.neededExp
        progressBar.max = myApp.playerLevel * 10
        // レベルアップに必要な経験値
        tvNeedExp.text = (myApp.exp+myApp.playerLevel*10-myApp.neededExp).toString() + " / " + (myApp.playerLevel*10).toString() + "  exp"
        tvLevel.text = "Lv."+myApp.playerLevel



        // ホームに戻るボタン
        exerciseResultFinishButton.setOnClickListener{
            finish()
        }

    }
}