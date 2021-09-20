package com.helloworld.sections.chat.moreItems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.R;
import com.helloworld.sections.chat.model.SendState;

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

        View itemView = LayoutInflater.from(mContext).inflate(R.layout.chat_more_item, parent, false);
        MoreItemViewHolder moreItemViewHolder = new MoreItemViewHolder(itemView);
        return moreItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoreItemViewHolder holder, int position) {
        MoreItem item = mItems.get(position);
        holder.mImageView.setImageDrawable(item.imageDrable);
        holder.mTextView.setText(item.title);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class MoreItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextView;
        public MoreItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.item_imageview);
            mTextView = itemView.findViewById(R.id.item_title_textview);

        }
    }
}
