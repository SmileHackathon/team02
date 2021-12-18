package com.example.smile_hackathon_product

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager.*
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import org.json.JSONObject
import java.io.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*


class MainActivity : AppCompatActivity() {

    var myApp = MyApplication.getInstance()

    private fun getDailyBonus(plusPoint: Int) {
        myApp.gatchaPoint += plusPoint
        val editor = getSharedPreferences(myApp.preferencePath, Context.MODE_PRIVATE).edit()
        editor.putInt(myApp.gatchaPointStr, myApp.gatchaPoint)
        editor.apply()
    }

    private fun dailyBonus(){
        val sharedPreference = getSharedPreferences(myApp.preferencePath, Context.MODE_PRIVATE)
        //日時取得
        val nowDate: LocalDate = LocalDate.now()
        // 記録してた日時取得
        val visitedDateKey:String = "lastVisitedDate"
//        val recordedDate = myApp.getValueString(visitedDateKey)
        val recordedDate = sharedPreference.getString(visitedDateKey, "")
        if( nowDate.toString() != recordedDate ) {
            // デイリーボーナスをゲットする
            getDailyBonus(10)
            // 画面遷移
            var intent = Intent(this, DailyBonusActivity::class.java)
            startActivity(intent)
        }
        // 日時更新
//        myApp.putValue(visitedDateKey, nowDate.toString())
        val editor = sharedPreference.edit()
        editor.putString(visitedDateKey, nowDate.toString())
        editor.apply()
    }

//     SaveVariable.kt内の変数を初期化する
//     ここでの初期化とはsharedPreferenceに記録されている値を呼び出すか、記録されていなければ指定した値をsharedPreferenceに記録してそれを与える
    public fun initVariables() {
        var sharedPreference = getSharedPreferences(myApp.preferencePath, Context.MODE_PRIVATE)

        //ガチャポイント、経験値、レベル
        myApp.gatchaPoint = sharedPreference.getInt(myApp.gatchaPointStr, 0)
        myApp.exp = sharedPreference.getInt(myApp.expStr, 0)
        myApp.playerLevel = sharedPreference.getInt(myApp.playerLevelStr, 1)
        myApp.neededExp = myApp.playerLevel * (10 + myApp.playerLevel*10) / 2

        var editor = sharedPreference.edit()
    // squatとwalkingは最初からある
        editor.putInt("Existed_squat", 1)
        editor.putInt("Existed_walking", 1)
        editor.apply()

        // exerciseMapとexercisePlayMapの初期化
        for (exerciseName in myApp.allExerciseList) {
            // 0で初期化
            myApp.exerciseMap[exerciseName] = sharedPreference.getInt("Existed_" + exerciseName, 0)
            myApp.exercisePlayMap[exerciseName] = sharedPreference.getInt("Played_"+ exerciseName, 0)
        }

        // existListとgatchaListの初期化
        for (exerciseName in myApp.allExerciseList){
            // exitListになければgatchaListに送る
            if(myApp.exerciseMap[exerciseName] == 1) {
                myApp.existList.add(exerciseName)
            }
            else {
                myApp.gatchaList.add(exerciseName)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

//        initVariables()
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_gatcha, R.id.navigation_daily_mission))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // 画面開くとデイリーボーナスかどうか判断する
        dailyBonus()

    }

    override fun onStart() {
        super.onStart()
        initVariables()
        Log.d("init", myApp.exerciseMap.toString())
        Log.d("init2", packageName)
    }
}
