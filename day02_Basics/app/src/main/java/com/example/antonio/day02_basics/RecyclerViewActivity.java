package com.example.antonio.day02_basics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.antonio.day02_basics.xmlparser.Message;
import com.example.antonio.day02_basics.xmlparser.PullParser;

import java.io.InputStream;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvMain;

    public List<Message> messages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mRvMain = (RecyclerView)findViewById(R.id.rv_list);
        mRvMain.setLayoutManager(new LinearLayoutManager(this));
        TextView tv_result = findViewById(R.id.tv_title);
        //load data from assets/data.xml
        try {
            InputStream assetInput = getAssets().open("data.xml");
            messages = PullParser.pull2xml(assetInput);
            for (Message message : messages) {
                tv_result.append(message.toString());
                tv_result.append("\n\n");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        mRvMain.setAdapter(new LinearAdapter(RecyclerViewActivity.this,messages,new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(RecyclerViewActivity.this,"click"+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
