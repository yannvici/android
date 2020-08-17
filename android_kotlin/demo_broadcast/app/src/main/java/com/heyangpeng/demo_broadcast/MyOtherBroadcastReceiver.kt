package com.heyangpeng.demo_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyOtherBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "received in MyOtherBroadcastReceiver", Toast.LENGTH_SHORT).show()
        abortBroadcast()
    }
}