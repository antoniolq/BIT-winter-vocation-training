package com.example.antonio.day06_mediaplay;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvmain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        mRvmain = (RecyclerView)findViewById(R.id.rv_main);
        mRvmain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        mRvmain.addItemDecoration(new RecycleViewDivider(LinearRecyclerViewActivity.this, LinearLayoutManager.VERTICAL));
//        mRvmain.addItemDecoration(new MyDecoration());
        mRvmain.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecyclerViewActivity.this,"click "+pos,Toast.LENGTH_SHORT).show();
            }
        }));
    }
//    class MyDecoration extends RecyclerView.ItemDecoration{
//        @Override
//        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
//            super.getItemOffsets(outRect, view, parent, state);
//            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
//        }
//    }

}
