package com.helloworld.sections.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.helloworld.R;

import java.util.ArrayList;
import java.util.List;

public class DeviceRCViewAdapter extends RecyclerView.Adapter<DeviceRCViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<BluetoothDevice> devices = new ArrayList<>();

    public DeviceRCViewAdapter(Context mContext, List<BluetoothDevice> devices) {
        this.mContext = mContext;
        this.devices = devices;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bluetooth_device_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getBindingAdapterPosition();
                BluetoothDevice device = devices.get(position);
                Log.e("click on one device", "onClick: "+ device.toString());

            }
        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BluetoothDevice device = devices.get(position);
        String name = device.getName();
        if (TextUtils.isEmpty(name)) {
            name = device.getAddress();
        }
        holder.deviceNameTextView.setText(name);
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    public  class  MyViewHolder extends RecyclerView.ViewHolder {
        private TextView deviceNameTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            deviceNameTextView = itemView.findViewById(R.id.deviceNameTextView);
        }
    }

    public void addDevice(BluetoothDevice deviece) {
        devices.add(deviece);
        notifyDataSetChanged();
    }

}
