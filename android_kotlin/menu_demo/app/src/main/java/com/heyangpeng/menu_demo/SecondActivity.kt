package com.heyangpeng.menu_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment

class SecondActivity : MainActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        addFragment(FirstFragment())
    }

    private fun addFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
//        val transition = fragmentManager.beginTransaction()
//        transition.replace(R.id.second_fragment, fragment)
//        transition.commit()
        fragmentManager.beginTransaction().apply {
            replace(R.id.second_fragment, fragment)
            commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_second, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item_second -> Toast.makeText(this, "ADD_SECOND", Toast.LENGTH_SHORT).show()
            R.id.remove_item_second -> Toast.makeText(this, "REMOVE_SECOND", Toast.LENGTH_SHORT)
                .show()
        }
        return super.onOptionsItemSelected(item)
    }
}