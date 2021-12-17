package com.example.smile_hackathon_product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DailyBonusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_bonus)

        // Viewの取得
        var tvBonus : TextView = findViewById(R.id.tv_bonus)
        var button : Button = findViewById(R.id.button)

        //instance呼び出し
        val myApp = MyApplication.getInstance()

        //text
        tvBonus.text = myApp.gatchaPoint.toString() + "ガチャポイント\nを獲得しました！"

        // ボタンが押されたときの処理
        button.setOnClickListener{
            finish()
        }


    }
}
