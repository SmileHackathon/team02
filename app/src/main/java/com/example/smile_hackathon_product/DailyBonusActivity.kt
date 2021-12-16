package com.example.smile_hackathon_product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DailyBonusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_bonus)

        // Viewの取得
        var tvBonus : TextView = findViewById(R.id.tv_bonus)


    }
}