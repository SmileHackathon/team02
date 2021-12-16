package com.example.smile_hackathon_product.ui.level

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.smile_hackathon_product.MyApplication
import com.example.smile_hackathon_product.R
import com.example.smile_hackathon_product.ui.gatcha.GatchaViewModel


class LevelFragment : Fragment() {
    private lateinit var levelViewModel: LevelViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        levelViewModel =
            ViewModelProvider(this).get(LevelViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_level, container, false)

        // Viewの取得
        val progressBar : ProgressBar = root.findViewById(R.id.progressbar)
        val tvLevel : TextView = root.findViewById(R.id.tv_level)
        val tvNeedExp : TextView = root.findViewById(R.id.tv_need_exp)
        val man : ImageView = root.findViewById(R.id.man)

        //instance呼び出し
        val myApp = MyApplication.getInstance()

        // レベルをprogressBarで表示
        progressBar.progress = myApp.exp+myApp.playerLevel*10-myApp.neededExp
        progressBar.max = myApp.playerLevel*10

        // レベルアップに必要な経験値
        tvNeedExp.text = (myApp.exp+myApp.playerLevel*10-myApp.neededExp).toString() + " / " + (myApp.playerLevel*10).toString() + "exp"
        tvLevel.text = "Lv."+myApp.playerLevel

        // レベルによって表示する画像が変わる
        if (myApp.playerLevel >= 10){
            man.setImageResource(R.drawable.man2)
        }

        return root
    }
}