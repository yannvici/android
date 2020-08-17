package com.heyangpeng.demo_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private lateinit var timeChangeBroadcastReceiver: TimeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //动态注册广播
        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
//        intentFilter.addAction("android.intent.action.MY_BRODCAST")
//        intentFilter.priority = 103
        timeChangeBroadcastReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeBroadcastReceiver, intentFilter)
        sendBroadcast.setOnClickListener {
            //静态注册广播
            val intent = Intent("android.intent.action.MY_BRODCAST")
            intent.setPackage(packageName)
            //  sendBroadcast(intent)//发送普通广播
            sendOrderedBroadcast(intent, null)//发送有序广播，第一个参数 intent 第二个参数是权限
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeBroadcastReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Time has changed!", Toast.LENGTH_SHORT).show()
//            abortBroadcast()
        }

    }
}