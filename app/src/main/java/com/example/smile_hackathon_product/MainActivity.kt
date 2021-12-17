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
    // preferce(データを永続的に保存するやつ)
//    private var sharedPreference = getSharedPreferences(packageName+"_preference", Context.MODE_PRIVATE)
    private fun readJson(path: String) : JSONObject {
        var inputStream: InputStream? = null
        try{
            inputStream = getAssets().open(path)
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            return JSONObject(jsonString)
        } catch (e: IOException) {
            Log.d("AppErr", "File openning failed")
        } finally {
            try {
                if (inputStream != null) inputStream.close()
            } catch (e: IOException) {
                Log.d("AppErr", "File closing failed")
            }
        }
        // 失敗したら空のjsonを返す
        return JSONObject("{}")
    }

    private fun getDailyBonus(plusPoint: Int): Int {
        //json開く
        val jsonObj = this.readJson("data.json")
        var gatchaPoint = jsonObj.getJSONObject("point").getInt("gatcha")
        gatchaPoint += plusPoint
        jsonObj.getJSONObject("point").put("gatcha", gatchaPoint)
        return gatchaPoint
    }


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

        //日時取得
     var sharedPreference = getSharedPreferences(packageName+"_preference", Context.MODE_PRIVATE)
        val nowDate: LocalDate = LocalDate.now()
        Log.d("NOW DATE", nowDate.toString())
        // jsonから記録してた日時取得
        val visitedDateKey:String = "lastVisitedDate"
        val recordedDate = sharedPreference.getString(visitedDateKey, "")
        Log.d("record", recordedDate.toString())
        if( nowDate.toString() != recordedDate ) {
            // デイリーボーナスをゲットする
            var gatchaPoint = getDailyBonus(10)

            // 画面遷移
            var intent = Intent(this, DailyBonusActivity::class.java)
            startActivity(intent)
        }
        // 日時更新
        val editor = sharedPreference.edit()
        editor.putString(visitedDateKey, nowDate.toString())
        editor.apply()
        val updateDate = sharedPreference.getString(visitedDateKey, "")
        Log.d("record", updateDate.toString())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()

    }
}

class AssetsProcess() : AppCompatActivity() {

}