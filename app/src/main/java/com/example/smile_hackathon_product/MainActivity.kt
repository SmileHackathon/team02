package com.example.smile_hackathon_product

//import android.R
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun scheduleNotification(content: String, calendar: Calendar) {
        val notificationIntent = Intent(this, AlarmReceiver::class.java)
        notificationIntent.putExtra(AlarmReceiver.NOTIFICATION_ID, 1)
        notificationIntent.putExtra(AlarmReceiver.NOTIFICATION_CONTENT, content)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.schedule_button).setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
//            calendar.set(Calendar.SECOND, 0)
//            calendar.set(Calendar.MINUTE, 6)
//            calendar.set(Calendar.HOUR_OF_DAY, 16)
            calendar.add(Calendar.SECOND, 10)
            scheduleNotification("10秒後に届く通知です", calendar)
        }
    }
}