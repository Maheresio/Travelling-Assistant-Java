package com.example.travellingassistant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdditionalRequestAdapter extends  RecyclerView.Adapter<AdditionalRequestAdapter.ViewHolder> {




    Context cx;
    private List<AdditionalRequestModel> additionalRequestList=new ArrayList<>();

    public AdditionalRequestAdapter(Context cx) {
        this.cx = cx;
    }

    @NonNull
    @Override
    public AdditionalRequestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView =LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_additional_request_item,parent,false);
        return new AdditionalRequestAdapter.ViewHolder(itemView);
    }

    //the most important one which make you edit the ui element

    @Override
    public void onBindViewHolder(@NonNull AdditionalRequestAdapter.ViewHolder holder, int i) {

        holder.storeNameTxtView.setText(additionalRequestList.get(i).storeName);
        holder.quantityTxtView.setText(additionalRequestList.get(i).quantity+" Ordered");
        holder.dateTxtView.setText((additionalRequestList.get(i).date).toString());
        holder.typeOfPieceTxtView.setText(additionalRequestList.get(i).type);
        holder.image.setImageResource(R.drawable.order);


    }

    @Override
    public int getItemCount() {
        return additionalRequestList.size();
    }


    public void setAdditionalRequestList(List<AdditionalRequestModel> additionalRequestList) {
        this.additionalRequestList = additionalRequestList;
        notifyDataSetChanged();
    }


/////////////////////////////////////////////////////
//you can access any element in this class

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView storeNameTxtView;
        TextView quantityTxtView;
        TextView typeOfPieceTxtView;
        TextView dateTxtView;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            storeNameTxtView =itemView.findViewById(R.id.additionalRequestTxtViewStoreName);
            dateTxtView=itemView.findViewById(R.id.additionalRequestTextViewDate);
            typeOfPieceTxtView=itemView.findViewById(R.id.additionalRequest_PieceType);
            quantityTxtView=itemView.findViewById(R.id.additionalRequestTxtViewQuantity);
            image=itemView.findViewById(R.id.additionalRequest_imageView);


        }
    }

}
