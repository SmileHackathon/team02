package com.example.smile_hackathon_product

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class GatchaResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gatcha_result)

        // Viewの取得
        var result : ImageView = findViewById(R.id.result)
        var retake : Button = findViewById(R.id.retake)
        var homeButton : Button = findViewById(R.id.home_button)

        //instance呼び出し
        val myApp = MyApplication.getInstance()

        // ガチャ結果の表示
        var gatchaResult = intent.getStringExtra("GATCHA_RESULT")

        if (gatchaResult == "squat"){
            result.setImageResource(R.drawable.squat)
        }
        if (gatchaResult == "walking"){
            result.setImageResource(R.drawable.walking)
        }
        if (gatchaResult == "running"){
            result.setImageResource(R.drawable.running)
        }
        if (gatchaResult == "plank"){
            result.setImageResource(R.drawable.plank)
        }
        if (gatchaResult == "fukkin"){
            result.setImageResource(R.drawable.fukkin)
        }
        if (gatchaResult == "haikinn"){
            result.setImageResource(R.drawable.haikinn)
        }
        if (gatchaResult == "udetate"){
            result.setImageResource(R.drawable.udetate)
        }

        // ボタンが押されたときの処理
        retake.setOnClickListener{
            var intent = Intent(this, GatchaResultActivity::class.java)
            val gatchaResultIndex = myApp.gatchaList.indices.random()
            var gatchaResult = myApp.gatchaList[gatchaResultIndex]

            myApp.gatchaList -= gatchaResult
            myApp.existList += gatchaResult
            myApp.exerciseMap[gatchaResult] = 1

            // リザルト画面にガチャ結果を送る
            intent.putExtra("GATCHA_RESULT",gatchaResult)

            startActivity(intent)
            finish()
        }
        homeButton.setOnClickListener{
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
