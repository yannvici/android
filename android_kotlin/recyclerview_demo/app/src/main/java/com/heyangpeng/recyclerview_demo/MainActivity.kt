package com.heyangpeng.recyclerview_demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var students: MutableList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        gridView.setOnClickListener(this)
        waterfallView.setOnClickListener(this)
        initStudents()
    }

    override fun onStart() {
        super.onStart()
        val listViewAdapter = ListViewAdapter(students)
        recyclerView.adapter = listViewAdapter
    }

    private fun initStudents() {
        students = ArrayList()
        for (i in 1..30) {
            val student = Student("Tom($i)", "Tom($i) is good boy!")
            students.add(student)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.gridView -> startActivity(Intent(this, GridViewActivity::class.java))
            R.id.waterfallView -> startActivity(Intent(this, WaterFullViewActivity::class.java))
        }
    }
}
