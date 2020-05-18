package com.heyangpeng.demo_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item:
                startActivity(new Intent().setClass(this,SecondActivity.class));
                Toast.makeText(this, "START_SECOND", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.remove_item:
                Toast.makeText(this, "REMOVE", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.group1:
                Toast.makeText(this, "group1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.group2:
                Toast.makeText(this, "group2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.group3:
                Toast.makeText(this, "group3", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
