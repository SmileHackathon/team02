package com.example.smile_hackathon_product

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
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
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_daily_mission))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        //日時取得
        // TODO:このフォーマットじゃだめ. year, month, dayだけでいい。またそれぞれを分割してint型で持つ
        val nowDate: LocalDate = LocalDate.now()
        // jsonから記録してた日時取得
        val jsonObj = recordActivity().readJson("date.json")
        val recordedDate = jsonObj.getInt("day")
        if( nowDate.dayOfMonth < recordedDate ) {
            // デイリーボーナスをゲットする
            getDailyBonus()
        }
        // nowDateをdate.jsonに更新する
        jsonObj.put("year", nowDate.year)
        jsonObj.put("month", nowDate.month)
        jsonObj.put("day", nowDate.dayOfMonth)
    }
}