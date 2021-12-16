package com.example.smile_hackathon_product

import android.app.Application
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController


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

class MyApplication : Application(){
    //この辺にActivity間で共有したい変数宣言する
    // 運動の配列
    var exercise_list = arrayOf("squat", "walking", "running", "plank", "fukkin", "haikinn", "udetate")
    var gatcha_list = arrayOf(1, 1, 0, 0, 0, 0, 0)

    companion object {
        private var instance : MyApplication? = null
        fun  getInstance(): MyApplication {
            if (instance == null)
                instance = MyApplication()
            return instance!!
        }
    }
}