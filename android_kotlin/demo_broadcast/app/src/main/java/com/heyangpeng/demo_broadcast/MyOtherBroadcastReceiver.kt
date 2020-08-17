package com.heyangpeng.demo_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MyOtherBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "received in MyOtherBroadcastReceiver", Toast.LENGTH_SHORT).show()
//        val mBundle: Bundle = Bundle().apply { putString("key", "MyOtherBroadcastReceiver") }
//        setResultExtras(mBundle)
        Log.e("MyOtherBroadcastReceiver", "onReceive(): $resultCode     data:$resultData")
        abortBroadcast()
    }
}