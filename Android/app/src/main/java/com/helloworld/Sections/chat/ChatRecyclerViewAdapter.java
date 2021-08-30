package com.helloworld.Sections.chat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ChatRecyclerViewAdapter extends RecyclerView.Adapter <ChatRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<MsgModel> data = new ArrayList<>();

    public ChatRecyclerViewAdapter(Context context, List<MsgModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder  {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
