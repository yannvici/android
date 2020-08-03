package com.heyangpeng.recyclerview_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_grid.*

class GridViewActivity : AppCompatActivity() {
    private lateinit var students: MutableList<Student>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 4)
        recyclerView_grid.layoutManager = layoutManager
        initStudents()
    }

    override fun onStart() {
        super.onStart()
        val gridAdapter = GridViewAdapter(students)
        recyclerView_grid.adapter = gridAdapter
    }

    private fun initStudents() {
        students = ArrayList()
        for (i in 1..30) {
            val student = Student("Tom($i)", "Tom($i) is good boy!")
            students.add(student)
        }
    }
}