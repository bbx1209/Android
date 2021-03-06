package com.helloworld.sections.Home.Model;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.basemodel.ActivityModel;
import com.helloworld.R;


import java.util.List;



public class HomeAdapter extends RecyclerView.Adapter <HomeAdapter.ViewHolder>  {

    private List<ActivityModel> itemList;
    private  HomeAdapterListener listener;

    public interface HomeAdapterListener {
        public  void  clickListener(View view, ActivityModel model);
    }

    static  class  ViewHolder extends  RecyclerView.ViewHolder {

        TextView textView;

        @SuppressLint("ResourceType")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.homeitem);
        }

    }


    public HomeAdapter(List<ActivityModel> itemList, HomeAdapterListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = viewHolder.textView.getText().toString();
                Toast.makeText(view.getContext(), name, Toast.LENGTH_SHORT).show();

                int adapterPosition = viewHolder.getAbsoluteAdapterPosition();
                ActivityModel model = itemList.get(adapterPosition);
                listener.clickListener(v, model);
            }
        });




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ActivityModel model = itemList.get(position);

        holder.textView.setText(model.getMainTitle());

    }

    @Override
    public int getItemCount() {
        int count = itemList.size();
        return count;
    }


}
