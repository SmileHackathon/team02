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
<<<<<<< HEAD
        var button : Button = findViewById(R.id.button)
=======
//        var button : Button = findViewById(R.id.button)
>>>>>>> 49948b6b4df7d2aaa2db4a74aa28f6e5329e3614

        //instance呼び出し
        val myApp = MyApplication.getInstance()

        //text
        tvBonus.text = myApp.gatchaPoint.toString() + "ガチャポイントを獲得しました！"

        // ボタンが押されたときの処理
<<<<<<< HEAD
        button.setOnClickListener{
            finish()
        }
=======
//        button.setOnClickListener{
//            finish()
//        }
>>>>>>> 49948b6b4df7d2aaa2db4a74aa28f6e5329e3614


    }
}
