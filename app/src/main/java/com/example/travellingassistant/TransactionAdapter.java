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

public class TransactionAdapter extends  RecyclerView.Adapter<TransactionAdapter.ViewHolder>{

    private List<Transaction> transactionsList=new ArrayList<>();
    Context context;

    public TransactionAdapter(Context context) {
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView =LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_transaction_item,parent,false);
        return new TransactionAdapter.ViewHolder(itemView);


    }

    //the most important one which make you edit the ui element

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Transaction currentTransaction=transactionsList.get(i);

        holder.storeNameTxtView.setText(currentTransaction.getStoreName());
        holder.cashTxtView.setText("$"+currentTransaction.getCash());
        holder.dateTxtView.setText((currentTransaction.getDate()).toString());
        holder.productNameTxtView.setText(currentTransaction.getProductName());
        holder.img.setImageResource(R.drawable.store);


    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }


     List<Transaction>getTransactionsList()
    {
        return this.transactionsList;
    }
    public void setTransactionsList(List<Transaction>transactionsList)
    {
        this.transactionsList=transactionsList;
        notifyDataSetChanged();
    }



/////////////////////////////////////////////////////
//you can access any element in this class

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView storeNameTxtView;
        TextView cashTxtView;
        TextView productNameTxtView;
        TextView dateTxtView;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             storeNameTxtView =itemView.findViewById(R.id.transaction_txtViewStoreTitle);
             cashTxtView=itemView.findViewById(R.id.transaction_txtViewCash);
             productNameTxtView =itemView.findViewById(R.id.transaction_txtViewTypeOfPiece);
             dateTxtView=itemView.findViewById(R.id.transaction_txtViewDate);
             img=itemView.findViewById(R.id.transaction_imageView);


        }
    }

}
