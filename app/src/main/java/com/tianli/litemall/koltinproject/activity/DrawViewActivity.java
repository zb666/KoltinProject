package com.tianli.litemall.koltinproject.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tianli.litemall.koltinproject.R;

public class DrawViewActivity extends AppCompatActivity {

    private ArrayMap<String, String> mArrayMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawview);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mArrayMap = new ArrayMap<>();
        }
        mArrayMap.put("1", "2");
        String s = mArrayMap.get("1");
        findViewById(R.id.tvAnother).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrawViewActivity.this,SVGActivity.class));
            }
        });
    }

}
