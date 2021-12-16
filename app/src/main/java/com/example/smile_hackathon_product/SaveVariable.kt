package com.example.smile_hackathon_product

import android.app.Application

class MyApplication : Application(){
    //この辺にActivity間で共有したい変数宣言する
    // 運動の配列
    var exerciseNameMap = mutableMapOf("squat" to "スクワット", "walking" to "ウォーキング", "running" to "ランニング", "plank" to "プランク", "fukkin" to "腹筋", "haikinn" to "背筋", "udetate" to "腕立て伏せ")
    var exerciseTimeMap = mutableMapOf("squat" to "20回", "walking" to "20分", "running" to "10分", "plank" to "30秒", "fukkin" to "20回", "haikinn" to "20回", "udetate" to "10回")
    var exerciseExpMap = mutableMapOf("squat" to 20, "walking" to 20, "running" to 20, "plank" to 20, "fukkin" to 20, "haikinn" to 20, "udetate" to 20)
    var isExistList = arrayOf(1, 1, 0, 0, 0, 0, 0)
    var exerciseMap = mutableMapOf<String, Int>("squat" to 1, "walking" to 1, "running" to 0, "plank" to 0, "fukkin" to 0, "haikinn" to 0, "udetate" to 0)
    var gatchaList = mutableListOf("running", "plank", "fukkin", "haikinn", "udetate")
    var existList = mutableListOf("squat", "walking")
//    public var gatchaPoint = 0

    // level関連
    var playerLevel : Int = 1
    var exp : Int = 0
    var neededExp : Int = 10

    companion object {
        private var instance : MyApplication? = null
        fun  getInstance(): MyApplication {
            if (instance == null)
                instance = MyApplication()
            return instance!!
        }
    }
}