package com.heyangpeng.demo_fragment_kotlin

/**
 * 拓展String类
 */

operator fun String.times(n: Int) = repeat(n)
