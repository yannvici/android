package com.example.demo_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListAdapter(
    private val mContext: Context,
    private val dataList: MutableList<Student>,
    private val reSourceId: Int
) : ArrayAdapter<Student>(mContext, reSourceId, dataList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(reSourceId, parent, false)
            val name: TextView = view.findViewById(R.id.tv_name)
            val desc: TextView = view.findViewById(R.id.tv_desc)
            holder = ViewHolder(name, desc)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }
        val student: Student = dataList[position]
        holder.name.text = student.name
        holder.desc.text = student.desc
        return view
    }

    inner class ViewHolder(val name: TextView, val desc: TextView)
}