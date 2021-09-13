package com.helloworld.sections.Collection.Activity.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.helloworld.R;
import com.helloworld.dataprovider.DataItem;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ViewHolder> {

    private List<DataItem> mList;
    private Context mContext;

    public CollectionAdapter(List<DataItem> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.collection_item_vertical, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DataItem item = mList.get(position);
        Glide.with(holder.itemView).load(item.getLocalImage()).into(holder.imageView_v);
        holder.textView_v.setText(item.getTitle());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView_v ;
        private TextView  textView_v;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             imageView_v = itemView.findViewById(R.id.collec_image_view);
             textView_v = itemView.findViewById(R.id.collec_text_view);

         }
     }

}
