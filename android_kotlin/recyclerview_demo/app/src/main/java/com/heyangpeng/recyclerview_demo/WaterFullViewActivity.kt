package com.heyangpeng.recyclerview_demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_waterfall.*
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


class WaterFullViewActivity : AppCompatActivity() {
    private lateinit var students: MutableList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waterfall)
        val layoutManager: RecyclerView.LayoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView_waterfall.layoutManager = layoutManager
        initStudents()
    }

    override fun onStart() {
        super.onStart()
        val waterFallViewAdapter = WaterFullViewAdapter(students)
        recyclerView_waterfall.adapter = waterFallViewAdapter
    }

    private fun initStudents() {
        students = ArrayList()
        for (i in 1..30) {
            val name = "Tom($i)"
            val student = Student(getRandomLengthName1(name), "Tom($i) is good boy!")
            students.add(student)
        }
    }

    private fun getRandomLengthName(s: String): String {
        val random = Random()
        val buffer = StringBuffer()
        for (i in 0 until random.nextInt(20) + 5) {
            buffer.append(s)
        }
        return buffer.toString()
    }

    private fun getRandomLengthName1(s: String): String {
        val n = (5..20).random()
        val buffer = StringBuilder()
        repeat(n) {
            buffer.append(s)
        }
        return buffer.toString()
    }
}