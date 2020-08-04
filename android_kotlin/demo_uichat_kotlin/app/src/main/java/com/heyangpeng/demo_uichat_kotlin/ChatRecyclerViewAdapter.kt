package com.heyangpeng.demo_uichat_kotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ChatRecyclerViewAdapter(private val msgs: MutableList<MsgContent>) :
    RecyclerView.Adapter<MsgViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return msgs[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder =
        if (viewType == MsgContent.TYPE_SEND) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_msg_left_item, parent, false)
            MsgViewHolder.MsgLeftViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_msg_right_item, parent, false)
            MsgViewHolder.MsgRightViewHolder(view)
        }

    override fun getItemCount(): Int = msgs.size

    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        val msg = msgs[position]
        when (holder) {
            is MsgViewHolder.MsgLeftViewHolder -> holder.leftMsg.text = msg.content
            is MsgViewHolder.MsgRightViewHolder -> holder.rightMsg.text = msg.content
        }
    }
}