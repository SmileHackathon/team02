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
import org.json.JSONObject
import java.io.*


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

        val jsonobj = readJson("Sample.json")
//        print(jsonobj.get("sample"))
    }
    fun readJson(path: String) : JSONObject{
//        val assetManager = resources.assets
        var inputStream: InputStream? = null
        try{
            inputStream = getAssets().open(path)
            val jsonString = inputStream.bufferedReader().use { it.readText() }
            val jsonObject = JSONObject(jsonString)
            return jsonObject
        } catch (e: IOException) {
            Log.d("AppErr", "File openning failed")
        } finally {
            try {
                if (inputStream != null) inputStream.close()
            } catch (e: IOException) {
                Log.d("AppErr", "File closing failed")
            }
        }
        val js = JSONObject("{}")
        return js
//        val jsonArray = jsonObject.getJSONArray(())
//        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
//        val str: String = bufferedReader.readText()
//        val jsonObject = JSONObject(str)
//        return jsonObject
    }
}