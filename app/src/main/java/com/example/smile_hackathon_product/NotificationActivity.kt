package com.example.smile_hackathon_product

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


// 通知に関するClass
// refs:https://codechacha.com/ja/notifications-in-android/
class NotificationActivity : AppCompatActivity() {
    // TODO: registerNotificationで引数にしている変数はclassの引数にしたほうが良い
    // Channelを作成する関数
    public fun createNotificationChannel(
        context: Context, importance: Int, showBadge: Boolean,
        name: String, description: String, channelId: String
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description
            channel.setShowBadge(showBadge)

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    // Notificationを登録する関数
    // 引数は(NOTIFICATION_ID: 通知のid,
    //       NewActivity:   通知から移動するActivity,
    //       channelId: channelを作成するときに使用したID,
    //       title: 通知のtitle,
    //       content: 通知の内容文)
    public fun registerNotification(
        NOTIFICATION_ID: Int,
        NewActivity: Activity,
        channelId: String,
        title: String,
        content: String
    ): NotificationManagerCompat {
        /*
            1. notification channelを作成していれば作成する
            2. channelを作成するときに使用したchannel ID. notification登録するときに必要
            3. PendingIntent. notificationをtouchしたときにactivityを実行するのに必要
            4. Notificationを作成するbuilder. ここでchannelIdを引数として配置する
            5. notificationに表示されるicon
            6. notificationのtitle
            7. notificationに表示されるtext
            8. notificationの重要度. 重要度によってnotificationが来ない場合がある
            9. AutoCancelがtrueの場合、userがnotificationをtouchしたとき消える。falseの場合消えない
            10. 上記で作成したPendingIntentをnotificationに登録する
            11. notificationManager.notify()でnotificationを登録する
         */
        createNotificationChannel(
            this, NotificationManagerCompat.IMPORTANCE_DEFAULT,
            false, getString(R.string.app_name), "App notification channel", channelId
        ) // 1

        // channelId, title, contentは引数で取ることに // 2

        val intent = Intent(baseContext, NewActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            baseContext, 0,
            intent, PendingIntent.FLAG_UPDATE_CURRENT
        )    // 3

        val builder = NotificationCompat.Builder(this, channelId)  // 4
        builder.setSmallIcon(R.drawable.notification_icon)    // 5
        builder.setContentTitle(title)    // 6
        builder.setContentText(content)    // 7
        builder.priority = NotificationCompat.PRIORITY_DEFAULT    // 8
        builder.setAutoCancel(true)   // 9
        builder.setContentIntent(pendingIntent)   // 10

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(NOTIFICATION_ID, builder.build())    // 11

        return notificationManager
    }
}

// Intentを受け取り、NotificationManagerを用いて通知を送る
class AlarmReceiver : BroadcastReceiver() {
    // 内容とIntentを受け取る
    override fun onReceive(context: Context, intent: Intent) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val id = intent.getIntExtra(NOTIFICATION_ID, 0)
        val content = intent.getStringExtra(NOTIFICATION_CONTENT)
        notificationManager.notify(id, buildNotification(context, content))
    }

    private fun buildNotification(context: Context, content: String?): Notification {
        val builder: Notification.Builder = Notification.Builder(context)
        builder.setContentTitle("Notification!!")
            .setContentText(content)
            .setSmallIcon(android.R.drawable.sym_def_app_icon)
        return builder.build()
    }

    companion object {
        var NOTIFICATION_ID = "notificationId"
        var NOTIFICATION_CONTENT = "content"
    }
}