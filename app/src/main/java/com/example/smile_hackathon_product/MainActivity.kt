package com.example.smile_hackathon_product

import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.widget.ImageButton
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.smile_hackathon_product.ui.dashboard.DashboardFragment
import com.example.smile_hackathon_product.ui.recordActivity
import org.json.JSONObject
import java.io.*
import java.text.SimpleDateFormat
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

    override fun onStart() {
        super.onStart()
        //日時取得
        // TODO:このフォーマットじゃだめ. year, month, dayだけでいい。またそれぞれを分割してint型で持つ
        var dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        var date = Date(System.currentTimeMillis())
        val nowDate = dateFormat.format(date)
        // jsonから記録してた日時取得
        val jsonObj = recordActivity().readJson("date.json")
        val recordedDate = jsonObj.get("day")
        if( nowDate < recordedDate ) {
            // デイリーボーナスをゲットする
            getDailyBonus()
        }
    }
}