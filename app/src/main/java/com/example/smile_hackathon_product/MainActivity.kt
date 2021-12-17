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

    // TODO: dailyMission一日一回になってなかった. 保存すべきかも
    // TODO: exercisePlayMapも一日一回更新する
    private fun dailySetting(){
        val sharedPreference = getSharedPreferences(myApp.preferencePath, Context.MODE_PRIVATE)
        //日時取得
        val nowDate: LocalDate = LocalDate.now()
        // 記録してた日時取得
        val recordedDate = sharedPreference.getString(myApp.visitedDate, "")

        if( nowDate.toString() != recordedDate ) {
                // デイリーボーナスをゲットする
                getDailyBonus(10)
                // デイリーミッション更新=============

                val editor = sharedPreference.edit()
                if (myApp.existList.size <= 3){
                    myApp.dailyMissionList.plusAssign(myApp.existList)
                    for (i in myApp.existList.indices) {
                        editor.putString("dailyMission$i", myApp.existList[i])
                        editor.apply()
                    }
                    // existList.sizeが2の時
                    if (myApp.existList.size == 2) {
                        editor.putString("dailyMission2", "")
                        editor.apply()
                    }
                } else {
                    // dailyMissionにexistList全部足す
                    myApp.dailyMissionList.plusAssign(myApp.existList)
                    // 残り3個になるまでdailyMissionから抜いていく
                    for (i in 0..(myApp.existList.size-4)){
                        // なるほど
                        myApp.dailyMissionList.minusAssign(myApp.dailyMissionList[(0 until myApp.dailyMissionList.size).random()])
                    }
                    for (i in 0..2) {
                        editor.putString("dailyMission$i", myApp.dailyMissionList[i])
                        editor.apply()
                    }
                }
                // =================================
                // exercisePlayMapを更新する
                for (exerciseName in myApp.allExerciseList) {
                    editor.putInt("Played_$exerciseName", 0)
                }
                editor.apply()
                // 画面遷移
                var intent = Intent(this, DailyBonusActivity::class.java)
                startActivity(intent)
            }
        // 日時更新
//        myApp.putValue(visitedDateKey, nowDate.toString())
        val editor = sharedPreference.edit()
        editor.putString(myApp.visitedDate, nowDate.toString())
        editor.apply()
    }

//     SaveVariable.kt内の変数を初期化する
//     ここでの初期化とはsharedPreferenceに記録されている値を呼び出すか、記録されていなければ指定した値をsharedPreferenceに記録してそれを与える
     fun initVariables() {
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
            myApp.exerciseMap[exerciseName] = sharedPreference.getInt("Existed_$exerciseName", 0)
            myApp.exercisePlayMap[exerciseName] = sharedPreference.getInt("Played_$exerciseName", 0)
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

        // dailyMission
        sharedPreference = getSharedPreferences(myApp.preferencePath, Context.MODE_PRIVATE)
        for (i in 0..2){
            myApp.dailyMissionList[i] = sharedPreference.getString("dailyMission$i", "").toString()
        }
    }
    fun clearSettings() {
        val sp = getSharedPreferences(myApp.preferencePath, Context.MODE_PRIVATE)
        sp.edit().putString(myApp.visitedDate, "").apply()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        clearSettings()
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
    }

    override fun onStart() {
        super.onStart()
        initVariables()
        dailySetting()
        Log.d("dailyM1", myApp.dailyMissionList[0].toString())
        Log.d("dailyM2", myApp.dailyMissionList[1].toString())
        Log.d("dailyM3", myApp.dailyMissionList[2].toString())
//        Log.d("existSize", myApp.existList.size.toString())
//        Log.d("init", myApp.exerciseMap.toString())
//        Log.d("init2", packageName)
    }
}


