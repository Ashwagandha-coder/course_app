package com.example.listcourseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.listcourseapp.domain.DateAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DateAdapter dateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setProperties();
    }

    public void init() {

        recyclerView = findViewById(R.id.rv_main);
        dateAdapter = new DateAdapter(22,this);

    }


    public void setProperties() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(dateAdapter);





    }

}