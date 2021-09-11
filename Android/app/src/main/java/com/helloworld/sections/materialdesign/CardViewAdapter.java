package com.helloworld.Sections.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.helloworld.R;

import java.util.List;
import com.helloworld.Sections.materialdesign.CardModel;
import com.helloworld.sections.materialdesign.CardDetailActivity;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {

    private Context context;
    private  List<CardModel> data;

    public CardViewAdapter(Context context, List<CardModel> list) {
        this.context = context;
        this.data = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                CardModel model = data.get(position);
                Intent intent = new Intent(context, CardDetailActivity.class);
                intent.putExtra("name", model.getName());
                intent.putExtra("imageId", model.getImageId());
                context.startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CardModel model = data.get(position);
        holder.textView.setText(model.getName());

        Glide.with(context).load(model.getImageId()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class  ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.card_textview);
            imageView = itemView.findViewById(R.id.card_imageview);
        }
    }


}
