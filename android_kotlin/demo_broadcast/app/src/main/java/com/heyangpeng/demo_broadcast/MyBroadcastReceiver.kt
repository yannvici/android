package com.heyangpeng.demo_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show()
        abortBroadcast()//如果在onReceive（）调用了abortBroadcast（）方法，表示将这条广播截断，后续的BroadcastReceiver无法接收这条广播，常和priority一起使用。即有序广播
    }
}