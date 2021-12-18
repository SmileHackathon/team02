package com.example.smile_hackathon_product

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.MediaController
import android.net.Uri
import android.widget.VideoView


class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        // 映像
        var videoView = findViewById<VideoView>(R.id.videoView)
        Handler(mainLooper).postDelayed({
            var moviePath = Uri.parse("android.resource://"+ packageName +"/"+ R.raw.effect)
            videoView.setVideoURI(moviePath)

            videoView.setOnPreparedListener{
                videoView.start()

                videoView.setMediaController(MediaController(this))
            }

            videoView.setOnCompletionListener{
                var gatchaResult = intent.getStringExtra("GATCHA_RESULT")
                var intent = Intent(this, GatchaResultActivity::class.java)

                intent.putExtra("GATCHA_RESULT",gatchaResult)
                startActivity(intent)
                finish()
            }
        }, 280)
    }
}