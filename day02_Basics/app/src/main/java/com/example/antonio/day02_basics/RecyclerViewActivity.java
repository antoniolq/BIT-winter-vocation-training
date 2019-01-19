package com.example.antonio.day02_basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mRvMain = (RecyclerView)findViewById(R.id.rv_list);
        mRvMain.setLayoutManager(new LinearLayoutManager(this));
        mRvMain.setAdapter(new LinearAdapter(this));
    }
}
