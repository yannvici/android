package com.heyangpeng.demo_uichat_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val msgs: MutableList<MsgContent> = ArrayList()

    //lateinit 延时初始化关键词，一般用于初始化全局变量。通常和  if (!::全局变量.isInitialized) {}一起使用。
    private lateinit var adapter: ChatRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initMsg()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerview_content.layoutManager = layoutManager
        adapter = ChatRecyclerViewAdapter(msgs)
        recyclerview_content.adapter = adapter
        btSend.setOnClickListener(this)
    }

    private fun initMsg() {
        val msgContent = MsgContent("Hello, guy!", MsgContent.TYPE_RECEIVED)
        msgs.add(msgContent)
        val msgContent1 = MsgContent("Hello, who is that?", MsgContent.TYPE_SEND)
        msgs.add(msgContent1)
        val msgContent2 = MsgContent("This is Yann. Nice to talking to u", MsgContent.TYPE_RECEIVED)
        msgs.add(msgContent2)
    }

    override fun onClick(v: View?) {
        when (v) {
            btSend -> {
                val content: String = etInput.text.toString()
                if (content.isNotEmpty()) {
                    val msg = MsgContent(content, MsgContent.TYPE_SEND)
                    msgs.add(msg)
                    if (!::adapter.isInitialized) {
                        adapter = ChatRecyclerViewAdapter(msgs)
                    }
                    adapter.notifyItemInserted(msgs.size - 1)//当adapter中有新内容时，刷新
                    recyclerview_content.scrollToPosition(msgs.size - 1)//将recyclerview定位到最后一行
                    etInput.setText("")
                }
            }
        }
    }
}