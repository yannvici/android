package com.example.demo_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private val dataList: MutableList<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addStudent()
    }

    override fun onStart() {
        super.onStart()
        val adapter = ListAdapter(this, dataList, R.layout.layout_list_item)
        list_view.adapter = adapter
        list_view.onItemClickListener = this
//        list_view.setOnItemClickListener { _, _, position, _ ->
//            val student = dataList[position]
//            Toast.makeText(this, student.desc, Toast.LENGTH_SHORT).show()
//        }
    }

    private fun addStudent() {
        for (i in 1..30) {//.. 双闭，until 前闭后开；downTo 降序
            val student = Student("Tom($i)", "Tom($i) is a good boy!")
            dataList.add(student)
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val student = dataList[position]
        Toast.makeText(this, student.desc, Toast.LENGTH_SHORT).show()
    }
}
