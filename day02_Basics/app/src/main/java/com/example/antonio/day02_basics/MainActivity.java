package com.example.antonio.day02_basics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.exercise1).setOnClickListener(this);
        findViewById(R.id.exercise2).setOnClickListener(this);
        findViewById(R.id.exercise3).setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exercise1:
                startActivity(new Intent(this, StateInspect.class));
                break;
            case R.id.exercise2:
                startActivity(new Intent(this, ViewCount.class));
                break;
            case R.id.exercise3:
                startActivity(new Intent(this, RecyclerViewActivity.class));
                break;
        }
    }
}
