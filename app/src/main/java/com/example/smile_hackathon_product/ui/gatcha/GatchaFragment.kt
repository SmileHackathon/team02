package com.example.smile_hackathon_product.ui.gatcha

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.smile_hackathon_product.GatchaResultActivity
import com.example.smile_hackathon_product.MovieActivity
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
        var tvGatcha : TextView = root.findViewById(R.id.tv_gatcha)

        //instance呼び出し
        val myApp = MyApplication.getInstance()

        // textの表示
        tvGatcha.text = "所有ポイント" + myApp.gatchaPoint.toString() + "ポイント"

        // ボタンが押されたときの処理
        if (myApp.gatchaPoint >= 100) { // 100ポイント以上持っているときだけガチャが引ける
            gatchaButton.setOnClickListener {
                var intent = Intent(activity, MovieActivity::class.java)
                val gatchaResultIndex = myApp.gatchaList.indices.random()
                var gatchaResult = myApp.gatchaList[gatchaResultIndex]

                //ガチャポイントの消費
                myApp.gatchaPoint -= 100
                // ガチャに入ってる運動の数を減らす
                myApp.gatchaList.minusAssign(gatchaResult)
                // 持ってる運動の数を増やす
                myApp.existList.plusAssign(gatchaResult)
                myApp.exerciseMap[gatchaResult] = 1

                // リザルト画面にガチャ結果を送る
                intent.putExtra("GATCHA_RESULT", gatchaResult)

                startActivity(intent)
            }
        }

        return root
    }
}