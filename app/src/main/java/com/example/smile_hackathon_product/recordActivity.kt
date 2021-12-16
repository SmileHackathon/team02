package com.example.smile_hackathon_product

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class recordActivity : AppCompatActivity(){
    //assetsから引数にassets下のjsonのpathを与えてJSONObjectを返す
    //getAssets().open(path)でファイルが開けなくて困っている
    public fun readJson(path: String) : JSONObject {
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

}