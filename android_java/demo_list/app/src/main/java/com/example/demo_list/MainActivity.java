package com.example.demo_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Student> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataList = new ArrayList<>();
        addStudent();

    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView listView = findViewById(R.id.list_view);
        ListAdapter adapter = new ListAdapter(this, dataList, R.layout.layout_list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String desc = dataList.get(position).getDesc();
                Toast.makeText(MainActivity.this, desc, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addStudent() {
        for (int i = 1; i < 30; i++) {
            Student student = new Student();
            student.setName("Tom(" + i + ")");
            student.setDesc("Tom(" + i + ")" + " is a good boy!");
            dataList.add(student);
        }
    }

}
