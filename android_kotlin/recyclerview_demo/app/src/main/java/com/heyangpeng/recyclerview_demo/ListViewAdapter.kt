package com.heyangpeng.recyclerview_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListViewAdapter(private val students: MutableList<Student>) :
    RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewAdapter.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = students.size

    override fun onBindViewHolder(holder: ListViewAdapter.ViewHolder, position: Int) {
        holder.name.text = students[position].name
        holder.desc.text = students[position].desc
        holder.itemView.setOnClickListener {
            Toast.makeText(
                context,
                students[position].desc,
                Toast.LENGTH_SHORT
            ).show() }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tv_name)
        val desc: TextView = view.findViewById(R.id.tv_desc)
    }
}