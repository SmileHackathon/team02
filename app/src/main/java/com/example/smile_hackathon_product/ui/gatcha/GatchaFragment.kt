package com.example.smile_hackathon_product.ui.gatcha

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.smile_hackathon_product.GatchaResultActivity
import com.example.smile_hackathon_product.MyApplication
import com.example.smile_hackathon_product.R

class GatchaFragment : Fragment() {

    private lateinit var gatchaViewModel: GatchaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gatchaViewModel =
            ViewModelProvider(this).get(GatchaViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gatcha, container, false)

        // Viewの取得
        var gatchaButton : Button = root.findViewById(R.id.gatcha_button)

        //instance呼び出し
        val myApp = MyApplication.getInstance()

        // ボタンが押されたときの処理
        gatchaButton.setOnClickListener{
            var intent = Intent(activity, GatchaResultActivity::class.java)
            val gatchaResultIndex = myApp.gatchaList.indices.random()
            var gatchaResult = myApp.gatchaList[gatchaResultIndex]

            // ガチャに入ってる運動の数を減らす
            myApp.gatchaList -= gatchaResult
            // 持ってる運動の数を増やす
            myApp.existList += gatchaResult
            myApp.exerciseMap[gatchaResult] = 1

            // リザルト画面にガチャ結果を送る
            intent.putExtra("GATCHA_RESULT",gatchaResult)

            startActivity(intent)
        }

        return root
    }
}