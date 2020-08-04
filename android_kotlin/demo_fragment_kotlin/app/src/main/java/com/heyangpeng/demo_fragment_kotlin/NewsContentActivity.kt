package com.heyangpeng.demo_fragment_kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_news_content.*

class NewsContentActivity : AppCompatActivity() {
    companion object {
        fun actionStart(context: Context, title: String, content: String) {
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra("newsTitle", title)
                putExtra("NewsContent", content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)
        val title = intent.getStringExtra("newsTitle")
        val content = intent.getStringExtra("NewsContent")
        if (title != null && content != null) {
            //一定要强转为NewsContentPaidFragment，否则调用不到里面的方法
            val fragment = newsContent as NewsContentPaidFragment
            fragment.refresh(title, content)
        }
    }
}