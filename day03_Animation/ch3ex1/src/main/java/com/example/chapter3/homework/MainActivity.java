package com.example.chapter3.homework;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    private LottieAnimationView animationView;
    private CheckBox loopCheckBox;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationView = (LottieAnimationView)findViewById(R.id.animation_view);
        animationView.playAnimation();
        loopCheckBox = findViewById(R.id.loop_checkbox);
        seekBar = findViewById(R.id.seekbar);
        animationView.useHardwareAcceleration();
        animationView.setProgress(0.5f);
        loopCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if(isChecked){
                    animationView.playAnimation();
//                    animationView.
                }else{
                    animationView.pauseAnimation();
                }
            }
        });
//        animationView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
////            public void onAnimationUpdate(ValueAnimator valueAnimator) {
////                seekBar.setProgress((int) (valueAnimator.getAnimatedFraction() * 100));
////            }
////        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO 3: 这里应该调用哪个函数呢
                // 提示1：可以参考 https://airbnb.io/lottie/android/android.html#custom-animators
                // 提示2：SeekBar 的文档可以把鼠标放在 OnProgressChanged 中间，并点击 F1 查看，
                // 或者到官网查询 https://developer.android.com/reference/android/widget/SeekBar.OnSeekBarChangeListener.html#onProgressChanged(android.widget.SeekBar,%20int,%20boolean)
                animationView.setProgress((float)(progress/100.0));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

}
