package com.heyangpeng.demo_broadcast

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 在同一个有序广播中数据是从权限高的receiver递减传递，sendOrderedBroadcast方法中resultReceiver为最终receiver
 * 当receiver被abortBroadcast（）后传递终止
 * resultData可以直接传递
 */
class MainActivity : AppCompatActivity() {
    private lateinit var timeChangeBroadcastReceiver: TimeChangeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //动态注册广播
        val intentFilter = IntentFilter()
//        intentFilter.addAction("android.intent.action.TIME_TICK")
//        intentFilter.addAction("android.intent.action.MY_BRODCAST")
//        intentFilter.priority = 10
        timeChangeBroadcastReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeBroadcastReceiver, intentFilter)
        sendBroadcast.setOnClickListener {
            //静态注册广播
            val intent = Intent("android.intent.action.MY_BRODCAST")
            intent.setPackage(packageName)
            //  sendBroadcast(intent)//发送普通广播
            sendOrderedBroadcast(intent, null)//发送有序广播，第一个参数 intent 第二个参数是权限
        }

        sendBroadcastResult.setOnClickListener {
            val intent = Intent("android.intent.action.MY_BRODCAST").apply {
                setPackage(packageName)
                putExtra("key", "this is one")
            }
            val mThread = HandlerThread("MyThread")
            mThread.start()
            val mHandler = Handler(mThread.looper)
            val mBundle: Bundle = Bundle().apply { putString("key", "initialExtras") }
            //sendOrderedBroadcast(
            //        要发送的广播
            //        Intent intent,
            //        发送的广播的权限，如果是null，即认为没有，任何符合条件的接收器都能收到
            //        String receiverPermission,
            //        Your own BroadcastReceiver to treat as the final receiver of the broadcast.
            //        BroadcastReceiver resultReceiver,
            //        A custom Handler with which to schedule the resultReceiver callback; if null it will be scheduled in the Context's main thread.
            //        （自定义的一个handler，来处理resultReceiver的回调，（其实就是设置运行这个接收器的线程），如果为null，默认在主线程）
            //        eg:      val mThread = HandlerThread("MyThread")
            //                 mThread.start()
            //                 val mHandler = Handler(mThread.looper)
            //        Handler scheduler,
            //        An initial value for the result code. Often Activity.RESULT_OK
            //        int initialCode,
            //        An initial value for the result data. Often null
            //        String initialData,
            //        An initial value for the result extras. Often null
            //        广播传递的数据初始化
            //        eg:
            //            val mBundle: Bundle = Bundle().apply { putString("key", "initialExtras") }
            //            setResultExtras(mBundle)
            //        Bundle initialExtras)
            sendOrderedBroadcast(
                intent,
                null,
                TimeChangeReceiver(),
                mHandler,
                Activity.RESULT_OK,
                "this is one",
                mBundle
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeBroadcastReceiver)
    }

    //获取广播传递的数据
    inner class TimeChangeReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Time has changed!", Toast.LENGTH_SHORT).show()
            val mBundle = getResultExtras(true)
            val data = resultData
            if (resultCode == -1) {
                Log.e(
                    "MainActivity",
                    "TimeChangeReceiver():" + mBundle.getString("key") + "    当前线程:" + Thread.currentThread().name + "    data:" + data
                )
            }

        }

    }
}