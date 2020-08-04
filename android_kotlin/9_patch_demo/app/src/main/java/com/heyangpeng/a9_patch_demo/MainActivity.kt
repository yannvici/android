package com.heyangpeng.a9_patch_demo

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvPNG.text = resources.getString(R.string.picture_png)
        tv9Patch.text = resources.getString(R.string.picture_9_patch)
    }
}