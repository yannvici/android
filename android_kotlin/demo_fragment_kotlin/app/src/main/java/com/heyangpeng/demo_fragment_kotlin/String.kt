package com.heyangpeng.demo_fragment_kotlin

/**
 * 拓展String类
 */
/**
 * 运算符重载对应函数名
 * a+b -> a.plus(b)
 * a-b -> a.minus(b)
 * a*b -> a.times(b)
 * a/b -> a.div(b)
 * a%b -> a.rem(b)
 * a++ -> a.inc(b)
 * a-- -> a.dec(b)
 * +a -> a.unaryPlus(b)
 * -a -> a.unaryMinus(b)
 * !a -> a.not(b)
 * a==b -> a.equals(b)
 * a>b ->
 * a<b ->
 * a>=b -> a.compareTo(b)
 * a<=b ->
 * a..b -> a.rangeTo(b)
 * a\[b] -> a.get(b)
 * a\[b]=c -> a.set(b,c)
 * a in b -> a.contains(b)
 */
operator fun String.times(n: Int) = repeat(n)
