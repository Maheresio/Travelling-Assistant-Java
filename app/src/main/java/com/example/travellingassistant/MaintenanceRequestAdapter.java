package com.example.travellingassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceRequestAdapter extends RecyclerView.Adapter<MaintenanceRequestAdapter.MaintenanceViewHolder>{

    private List<MaintenanceRequestModel> requestList=new ArrayList<>();
    Context context;

    public MaintenanceRequestAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MaintenanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_layout_maintenance_request_item,parent,false);
        return new MaintenanceRequestAdapter.MaintenanceViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(@NonNull MaintenanceViewHolder holder, int position) {

        MaintenanceRequestModel currentRequest=requestList.get(position);


        holder.textViewStoreName.setText(currentRequest.getStoreName());
        holder.textViewShortProductName.setText(currentRequest.getProductName());
        holder.textViewFlaw.setText(currentRequest.getFlaw());
        holder.textViewDesc.setText(currentRequest.getDesc());
        holder.textStatus.setText("Is Fixed?");
        holder.textStatusAnswer.setText(currentRequest.getAnswer());
        holder.imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.order));
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public void setRequestList(List<MaintenanceRequestModel>requestList)
    {
        this.requestList=requestList;
        notifyDataSetChanged();
    }


    static class MaintenanceViewHolder extends RecyclerView.ViewHolder {

        TextView textViewStoreName, textViewShortProductName, textViewFlaw, textViewDesc,textStatus,textStatusAnswer;
        ImageView imageView;

        public MaintenanceViewHolder(View itemView) {
            super(itemView);

            textViewStoreName = itemView.findViewById(R.id.main_textViewStoreName);
            textViewShortProductName = itemView.findViewById(R.id.main_textViewProductName);
            textViewFlaw = itemView.findViewById(R.id.main_textViewFlaw);
            textViewDesc = itemView.findViewById(R.id.main_textViewDesc);
            textStatusAnswer = itemView.findViewById(R.id.main_textViewStatusAnswer);
            textStatus = itemView.findViewById(R.id.main_textViewStatus);
            imageView = itemView.findViewById(R.id.imageView);
        }

    }
}
