package com.example.smile_hackathon_product

import android.app.Application
import android.content.Context

class MyApplication : Application(){
    //この辺にActivity間で共有したい変数宣言する
    // 運動の配列
    final var exerciseNameMap = mutableMapOf("momoage" to "モモ上げ","squat" to "スクワット", "walking" to "ウォーキング", "running" to "ランニング", "plank" to "プランク", "fukkin" to "腹筋", "haikinn" to "背筋", "udetate" to "腕立て伏せ")
    final var exerciseTimeMap = mutableMapOf("momoage" to "20回","squat" to "20回", "walking" to "20分", "running" to "10分", "plank" to "30秒", "fukkin" to "20回", "haikinn" to "20回", "udetate" to "10回")
    final var exerciseExpMap = mutableMapOf("momoage" to 20,"squat" to 20, "walking" to 20, "running" to 20, "plank" to 20, "fukkin" to 20, "haikinn" to 20, "udetate" to 20)

    final var allExerciseList = listOf<String>("momoage", "squat", "walking", "running", "plank", "fukkin", "haikin", "udetate")
    var exerciseMap = mutableMapOf<String, Int>("momoage" to 0, "squat" to 1, "walking" to 1, "running" to 0, "plank" to 0, "fukkin" to 0, "haikinn" to 0, "udetate" to 0)
    var exercisePlayMap = mutableMapOf<String, Int>("momoage" to 1, "squat" to 0, "walking" to 0, "running" to 0, "plank" to 0, "fukkin" to 0, "haikinn" to 0, "udetate" to 0)
    var gatchaList = mutableListOf<String>()
    var existList = mutableListOf<String>()
    var gatchaPoint = 0

    // level関連
    var playerLevel : Int = 1
    var exp : Int = 0
    var neededExp : Int = playerLevel * (10 + playerLevel*10) / 2

    val preferencePath: String = "com.example.smile_hackathon_product_preference"
    val gatchaPointStr = "gatchaPoint"
    val expStr = "exp"
    val playerLevelStr = "playerLevel"


    companion object {
        private var instance : MyApplication? = null
        fun  getInstance(): MyApplication {
            if (instance == null)
                instance = MyApplication()
            return instance!!
        }
    }
}