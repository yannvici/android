package com.heyangpeng.menu_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> {
                startActivity(Intent(this, SecondActivity::class.java))
                Toast.makeText(this, "START_SECOND", Toast.LENGTH_SHORT).show()
            }
            R.id.remove_item -> Toast.makeText(this, "REMOVE_ITEM", Toast.LENGTH_SHORT).show()
            R.id.group1 -> Toast.makeText(this, "GROUP1", Toast.LENGTH_SHORT).show()
            R.id.group2 -> Toast.makeText(this, "GROUP2", Toast.LENGTH_SHORT).show()
            R.id.group3 -> Toast.makeText(this, "GROUP3", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}