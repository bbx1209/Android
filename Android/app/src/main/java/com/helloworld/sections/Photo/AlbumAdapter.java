package com.helloworld.sections.Photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.R;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter {

    private final Context mContext;
    private List<MediaBean> mList;

    public AlbumAdapter(Context mContext, List<MediaBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public void setmList(List<MediaBean> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.album_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MediaBean bean = mList.get(position);

        if (holder instanceof  ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            Bitmap bitmap = BitmapFactory.decodeFile(bean.path);
            viewHolder.imageView.setImageBitmap(bitmap);
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.album_item_imageView);
            checkBox = itemView.findViewById(R.id.album_checkbox);
        }
    }
}
