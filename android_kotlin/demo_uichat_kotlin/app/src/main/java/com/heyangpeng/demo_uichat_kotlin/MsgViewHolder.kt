package com.heyangpeng.demo_uichat_kotlin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// sealed 定义密封类关键字，类似工厂模式中的工厂
sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    class MsgLeftViewHolder(view: View) : MsgViewHolder(view) {
        val leftMsg: TextView = view.findViewById(R.id.leftMsg)
    }

    class MsgRightViewHolder(view: View) : MsgViewHolder(view) {
        val rightMsg: TextView = view.findViewById(R.id.rightMsg)
    }
}