package com.example.antonio.day02_basics;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.TextView;

public class StateInspect extends AppCompatActivity {

    private static final String TAG = "wangyi";


    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";


    private TextView mLifecycleDisplay;


    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);
        mLifecycleDisplay.append(lifecycleEvent + "\n");
    }

    public void resetLifecycleDisplay(View view) {
        mLifecycleDisplay.setText("Lifecycle callbacks:\n");
    }

    public void showSaveInstance(View view) {
        startActivity(new Intent(this, SaveInstanceStateActivity.class));
    }

    public void showUpgradeDialog(View view) {
        new AlertDialog.Builder(this)
                .setTitle("应用升级")
                .setMessage("抖音1.1版本升级")
                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_inspect);
        startOrientationChangeListener();
        mLifecycleDisplay = findViewById(R.id.tv_loglifecycle);
        logAndAppend(ON_CREATE);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndAppend(ON_RESTART);
    }

    @Override
    protected void onStart() {
        super.onStart();
        logAndAppend(ON_START);
    }

    @Override
    protected void onResume() {
        super.onResume();
        logAndAppend(ON_RESUME);
    }


    @Override
    protected void onPause() {
        super.onPause();
        logAndAppend(ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        logAndAppend(ON_STOP);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logAndAppend(ON_DESTROY);
    }
    private OrientationEventListener mOrientationListener;
    private String TAG2 = "MainActivity";
    private int screenCurOrient = 2; //1表示正竖屏，2表示正横屏，3表示反竖屏，4表示反横屏

    private final void startOrientationChangeListener() {
        mOrientationListener = new OrientationEventListener(this) {
            @Override
            public void onOrientationChanged(int rotation) {
                //判断四个方向
                if (rotation == -1) {
                    Log.d(TAG, "手机平放:" + rotation);
                } else if (rotation < 10 || rotation > 350) {
                    screenOrientChange(1);
                } else if (rotation < 100 && rotation > 80) {
                    screenOrientChange(4);
                } else if (rotation < 190 && rotation > 170) {
                    screenOrientChange(3);
                } else if (rotation < 280 && rotation > 260) {
                    screenOrientChange(2);
                }
                else
                {
                }
            }
        };
        mOrientationListener.enable();
    }

    private void screenOrientChange(int Orient)
    {
        if(Orient != screenCurOrient)
        {
            screenCurOrient = Orient;
            switch (screenCurOrient)
            {
                case 1:
                    Log.d(TAG, "正竖屏:");
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    break;
                case 2:
                    Log.d(TAG, "正横屏:");
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    logAndAppend(ON_STOP);
                    logAndAppend(ON_DESTROY);
                    break;
                case 3:
                    Log.d(TAG, "反竖屏:");
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    logAndAppend(ON_STOP);
                    logAndAppend(ON_DESTROY);
                    break;
                case 4:
                    Log.d(TAG, "反横屏:");
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    logAndAppend(ON_STOP);
                    logAndAppend(ON_DESTROY);
                    break;
            }
        }
    }
}
