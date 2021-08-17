package com.helloworld.Sections.Home.Model;

import static com.helloworld.R.id.homeitem;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.BaseModel.ActivityModel;
import com.helloworld.R;
import com.helloworld.Sections.Home.View.HomeItem;



import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter <HomeAdapter.ViewHolder>  {

    private List<ActivityModel> itemList;

    static  class  ViewHolder extends  RecyclerView.ViewHolder {

        TextView textView;

        @SuppressLint("ResourceType")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(homeitem);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ActivityModel model = itemList.get(position);
        holder.textView.setText(model.mainTitle);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
