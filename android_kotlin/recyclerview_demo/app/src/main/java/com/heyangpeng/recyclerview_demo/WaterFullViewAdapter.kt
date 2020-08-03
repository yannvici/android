package com.heyangpeng.recyclerview_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class WaterFullViewAdapter(private val students: MutableList<Student>) :
    RecyclerView.Adapter<WaterFullViewAdapter.ViewHolder>() {
    private lateinit var mContext: Context

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView = v.findViewById(R.id.waterfall_tv_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val v = LayoutInflater.from(mContext)
            .inflate(R.layout.layout_recyclerview_waterfall_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = students.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = students[position].name
        holder.itemView.setOnClickListener {
            Toast.makeText(
                mContext,
                students[position].name,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}