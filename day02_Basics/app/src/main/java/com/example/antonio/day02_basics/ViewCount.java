package com.example.antonio.day02_basics;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewCount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_count);
        System.out.print(findViewById(R.id.statistics));
        getAllViews(this);
    }
    public void getAllViews(AppCompatActivity act) {
        List<View> allchildren = new ArrayList<View>();
        List<View> list = getAllChildViews(act.getWindow().getDecorView(),allchildren);
        System.out.print(findViewById(R.id.statistics));
    }

    public List<View> getAllChildViews(View view,List<View> allchildren) {
        if (view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewchild = vp.getChildAt(i);
                allchildren.add(viewchild);
                //再次 调用本身（递归）
                allchildren.addAll(getAllChildViews(viewchild,allchildren));
            }
        }
        return allchildren;
    }

}
