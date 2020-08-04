package com.heyangpeng.demo_uichat_kotlin

data class MsgContent(val content: String, val type: Int) {
    companion object {
        const val TYPE_RECEIVED = 0
        const val TYPE_SEND = 1
    }
}