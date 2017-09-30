package com.hfhuaizhi.tabtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2017\9\30 0030.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    Context mContext;
    public RecyclerViewAdapter(Context context){
mContext = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext,R.layout.item_test,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final View view = holder.itemView;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"你点了",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return 20;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ViewHolder(View itemView) {

            super(itemView);
            this.view = itemView;
        }
    }
}
