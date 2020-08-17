package com.heyangpeng.forcedofflinedemo

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forcedOffline.setOnClickListener {
            val intent = Intent("com.heyangpeng.forcedofflinedemo.FORCED_OFFLINE")
            sendBroadcast(intent)
        }
    }

}