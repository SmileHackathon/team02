package com.example.smile_hackathon_product

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import android.app.Application
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import java.io.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_gatcha, R.id.navigation_daily_mission))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        //TODO:関数かなんかにまとめたい--
        //日時取得
        val nowDate: LocalDate = LocalDate.now()
        // jsonから記録してた日時取得
        val jsonObj = recordActivity().readJson("data.json")
        val recordedDate = jsonObj.getJSONObject("date").getInt("day")
        if( nowDate.dayOfMonth < recordedDate ) {
            // デイリーボーナスをゲットする
            var x = GatchaResultActivity().getDailyBonus()
        }
        // nowDateをdate.jsonに更新する
        jsonObj.put("year", nowDate.year)
        jsonObj.put("month", nowDate.month)
        jsonObj.put("day", nowDate.dayOfMonth)
        //TODO:ここまで--------------------------------------------------
        // level
        val progressBar : ProgressBar = findViewById(R.id.progressbar)
        val tvLevel : TextView = findViewById(R.id.tv_level)



        var playerLevel : Int = 1
        var exp : Int = 0
        var neededExp : Int = 10

        progressBar.progress = exp
        progressBar.secondaryProgress = neededExp

        tvLevel.text = "Lv.$playerLevel"
    }
}

