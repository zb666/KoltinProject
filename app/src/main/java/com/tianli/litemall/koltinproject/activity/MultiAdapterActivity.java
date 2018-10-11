package com.tianli.litemall.koltinproject.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tianli.litemall.koltinproject.R;
import com.tianli.litemall.koltinproject.multipleadapter.Level0ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MultiAdapterActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiadapter);
        recyclerView = findViewById(R.id.recycleview);
        List<MultiItemEntity> list = new ArrayList<>();
        for (int i = 0;i<10;i++) {
            list.add(0, new MultiItemEntity() {
                @Override
                public int getItemType() {
                    return 0;
                }
            });
            list.add(1, new MultiItemEntity() {
                @Override
                public int getItemType() {
                    return 1;
                }
            });
            list.add(1, new MultiItemEntity() {
                @Override
                public int getItemType() {
                    return 1;
                }
            });
            list.add(1, new MultiItemEntity() {
                @Override
                public int getItemType() {
                    return 1;
                }
            });
        }
        Level0ItemAdapter level0ItemAdapter = new Level0ItemAdapter(list);
        recyclerView.setAdapter(level0ItemAdapter);
        level0ItemAdapter.collapse(0);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
