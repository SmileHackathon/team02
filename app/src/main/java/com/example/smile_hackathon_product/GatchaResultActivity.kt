package com.example.smile_hackathon_product

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class GatchaResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gatcha_result)

        // Viewの取得
        var result : ImageView = findViewById(R.id.result)
        var retake : Button = findViewById(R.id.retake)
        var homeButton : Button = findViewById(R.id.home_button)
        var tvGatchaResult : TextView = findViewById(R.id.tv_gatcha_result)

        //instance呼び出し
        val myApp = MyApplication.getInstance()

        // 所有ポイントの表示
        tvGatchaResult.text = "所有ポイント" + myApp.gatchaPoint.toString() + "ポイント"

        // ガチャ結果の表示
        var getGatchaResult = intent.getStringExtra("GATCHA_RESULT")

        if (getGatchaResult == "squat"){
            result.setImageResource(R.drawable.squat)
        }
        if (getGatchaResult == "walking"){
            result.setImageResource(R.drawable.walking)
        }
        if (getGatchaResult == "running"){
            result.setImageResource(R.drawable.running)
        }
        if (getGatchaResult == "plank"){
            result.setImageResource(R.drawable.plank)
        }
        if (getGatchaResult == "fukkin"){
            result.setImageResource(R.drawable.fukkin)
        }
        if (getGatchaResult == "haikinn"){
            result.setImageResource(R.drawable.haikinn)
        }
        if (getGatchaResult == "udetate"){
            result.setImageResource(R.drawable.udetate)
        }
        if (getGatchaResult == "momoage"){
            result.setImageResource(R.drawable.momoage)
        }

        // ボタンが押されたときの処理
        if (myApp.gatchaPoint >= 100) {
            retake.setOnClickListener {
                val intent = Intent(this, GatchaResultActivity::class.java)
                val gatchaResultIndex = myApp.gatchaList.indices.random()
                val gatchaResult = myApp.gatchaList[gatchaResultIndex]

                myApp.gatchaPoint -= 100
                myApp.gatchaList -= gatchaResult
                myApp.existList += gatchaResult
                myApp.exerciseMap[gatchaResult] = 1

                // リザルト画面にガチャ結果を送る
                intent.putExtra("GATCHA_RESULT", gatchaResult)

                startActivity(intent)
                finish()
            }
        }
        homeButton.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    public fun getDailyBonus(gatchaPoint: Int, plusPoint: Int): Int {
        //json開く
        val jsonObj = recordActivity().readJson("data.json")
        var gatchaPoint = jsonObj.getJSONObject("point").getInt("gatcha")
        gatchaPoint += plusPoint
        jsonObj.getJSONObject("point").put("gatcha", gatchaPoint)
        return gatchaPoint
    }
}
