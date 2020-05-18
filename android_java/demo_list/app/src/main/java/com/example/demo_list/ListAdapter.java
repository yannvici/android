package com.example.demo_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<Student> dataList;
    private int reSourceId;
    private LayoutInflater mInflater;


    ListAdapter(Context mContest, List<Student> dataList, int reSourceId) {
        this.mInflater = LayoutInflater.from(mContest);
        this.dataList = dataList;
        this.reSourceId = reSourceId;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(reSourceId, null);
            holder.name = convertView.findViewById(R.id.tv_name);
            holder.desc = convertView.findViewById(R.id.tv_desc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.desc.setText(dataList.get(position).getDesc());
        holder.name.setText(dataList.get(position).getName());
        return convertView;
    }

    private static class ViewHolder {
        private TextView name, desc;
    }
}
