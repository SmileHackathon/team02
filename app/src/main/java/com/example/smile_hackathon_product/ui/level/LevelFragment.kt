package com.example.smile_hackathon_product.ui.level

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        // level
        val progressBar : ProgressBar = root.findViewById(R.id.progressbar)
        val tvLevel : TextView = root.findViewById(R.id.tv_level)

        //instance呼び出し
        val myApp = MyApplication.getInstance()

        progressBar.progress = myApp.exp
        progressBar.secondaryProgress = myApp.neededExp

        tvLevel.text = "Lv."+myApp.playerLevel

        return root
    }
}