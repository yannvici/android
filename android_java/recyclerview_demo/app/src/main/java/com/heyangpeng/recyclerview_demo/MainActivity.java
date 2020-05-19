package com.heyangpeng.recyclerview_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Student> students;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        Button gridView = findViewById(R.id.gridView);
        Button waterfallView = findViewById(R.id.waterfallView);
        gridView.setOnClickListener(this);
        waterfallView.setOnClickListener(this);
        recyclerView.setLayoutManager(layoutManager);
        students = new ArrayList<>();
        initStudents();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListViewAdapter adapter = new ListViewAdapter(students, this);
        recyclerView.setAdapter(adapter);
    }

    private void initStudents() {
        for (int i = 1; i <= 30; i++) {
            Student student = new Student();
            student.setName("Tom(" + i + ")");
            student.setDesc("Tom(" + i + ")" + "is a good boy!");
            students.add(student);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.gridView:
                intent.setClass(this, GridViewActivity.class);
                break;
            case R.id.waterfallView:
                intent.setClass(this, WaterFallViewActivity.class);
                break;
        }
        startActivity(intent);
    }
}
