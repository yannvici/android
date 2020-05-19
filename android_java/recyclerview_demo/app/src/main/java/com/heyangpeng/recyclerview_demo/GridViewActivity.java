package com.heyangpeng.recyclerview_demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GridViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Student> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        recyclerView = findViewById(R.id.recyclerView_grid);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(layoutManager);
        data = new ArrayList<>();
        initStudents();
    }

    @Override
    protected void onStart() {
        super.onStart();
        GridViewAdapter adapter = new GridViewAdapter(data, this);
        recyclerView.setAdapter(adapter);
    }

    private void initStudents() {
        for (int i = 1; i <= 30; i++) {
            Student student = new Student();
            student.setName("Tom(" + i + ")");
            student.setDesc("Tom(" + i + ")" + "is a good boy!");
            data.add(student);
        }
    }
}
