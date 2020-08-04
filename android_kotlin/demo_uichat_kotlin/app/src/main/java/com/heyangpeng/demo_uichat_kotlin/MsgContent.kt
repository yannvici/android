package com.heyangpeng.demo_uichat_kotlin

data class MsgContent(val content: String, val type: Int) {
    companion object {
        // const 定义常量关键字，只能在单例类、companion object或顶层方法中使用
        const val TYPE_RECEIVED = 0
        const val TYPE_SEND = 1
    }
}