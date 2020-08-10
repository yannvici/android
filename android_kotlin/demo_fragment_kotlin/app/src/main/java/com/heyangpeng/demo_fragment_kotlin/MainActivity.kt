package com.heyangpeng.demo_fragment_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startFragment(NewsTitleFragment(), true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.another -> startFragment(AnotherFragment(), false)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun startFragment(fragment: Fragment, isFirst: Boolean) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, fragment)
            if (!isFirst)
                addToBackStack(null)//将fragment进栈，返回时返回上一个fragment
            commit()
        }
    }
}