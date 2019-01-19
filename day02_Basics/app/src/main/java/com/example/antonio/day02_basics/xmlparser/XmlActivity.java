package com.example.antonio.day02_basics.xmlparser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.antonio.day02_basics.R;

import java.io.InputStream;
import java.util.List;

public class XmlActivity extends AppCompatActivity {

    public List<Message> messages;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
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
    }
}
