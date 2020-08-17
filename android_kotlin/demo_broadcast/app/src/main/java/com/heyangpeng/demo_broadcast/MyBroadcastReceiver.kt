package com.heyangpeng.demo_broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "received in MyBroadcastReceiver", Toast.LENGTH_SHORT).show()
        val mBundle: Bundle = Bundle().apply { putString("key", "MyBroadcastReceiver") }
        resultData = "this is two"
        setResultExtras(mBundle)//可以将resultData传递下去
//        setResult(-1, resultData, mBundle)//结果一样，code区分
        // abortBroadcast()//如果在onReceive（）调用了abortBroadcast（）方法，表示将这条广播截断，后续的BroadcastReceiver无法接收这条广播，常和priority一起使用。即有序广播
    }
}