package com.helloworld.sections.chat.moreItems;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MoreItemAdapter extends RecyclerView.Adapter <MoreItemAdapter.MoreItemViewHolder> {

        private Context mContext;
        private List<MoreItem> mItems = new ArrayList<>();

    public MoreItemAdapter(Context mContext, List<MoreItem> mItems) {
        this.mContext = mContext;
        this.mItems = mItems;
    }

    @NonNull
    @Override
    public MoreItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MoreItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class MoreItemViewHolder extends RecyclerView.ViewHolder {
        public MoreItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
