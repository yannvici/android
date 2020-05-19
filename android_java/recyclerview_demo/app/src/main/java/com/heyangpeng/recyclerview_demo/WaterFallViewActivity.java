package com.heyangpeng.recyclerview_demo;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaterFallViewActivity extends AppCompatActivity {
    private List<Student> data;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall);
        data = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView_waterfall);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        initData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        WaterfallAdapter adapter = new WaterfallAdapter(data, this);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 1; i <= 30; i++) {
            Student student = new Student();
            String name = "Tom(" + i + ")";
            student.setName(getRandomLengthName(name));
            data.add(student);
        }
    }

    private String getRandomLengthName(String s) {
        Random random = new Random();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < random.nextInt(20) + 5; i++) {
            buffer.append(s);
        }
        return buffer.toString();
    }
}
