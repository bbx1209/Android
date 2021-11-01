package com.helloworld.sections.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
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
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BluetoothDevice device = devices.get(position);
        holder.deviceNameTextView.setText(device.getName());
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

}
