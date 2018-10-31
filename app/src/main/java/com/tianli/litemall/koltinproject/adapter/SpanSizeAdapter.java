package com.tianli.litemall.koltinproject.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianli.litemall.koltinproject.R;

public class SpanSizeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        TextView inflate = new TextView(viewGroup.getContext());
        inflate.setText("当前的位置："+i);
        SpanHolder spanHolder = new SpanHolder(inflate);
        return spanHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class SpanHolder extends RecyclerView.ViewHolder{

        public SpanHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
