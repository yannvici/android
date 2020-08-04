package com.heyangpeng.demo_uichat_kotlin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    class MsgLeftViewHolder(view: View) : MsgViewHolder(view) {
        val leftMsg: TextView = view.findViewById(R.id.leftMsg)
    }

    class MsgRightViewHolder(view: View) : MsgViewHolder(view) {
        val rightMsg: TextView = view.findViewById(R.id.rightMsg)
    }
}