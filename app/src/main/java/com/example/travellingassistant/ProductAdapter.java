package com.example.travellingassistant;

import android.annotation.SuppressLint;
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


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {




    //getting the context and product list with constructor

private List<Products> productsList=new ArrayList<>();
Context context;

    public ProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView =LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_layout_product_item,parent,false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Products currentProduct=productsList.get(position);


        holder.textViewTitle.setText(currentProduct.getName());
        holder.textViewShortDesc.setText(currentProduct.getDesc());
        holder.textViewQuantity.setText( currentProduct.getQuantity() + " in stock ");
        holder.textViewPrice.setText('$'+String.valueOf(currentProduct.getPrice()));
        holder.imageView.setImageDrawable(ContextCompat.getDrawable(context, currentProduct.getImage()));
    }

    public void setProductsList(List<Products>productsList)
    {
        this.productsList=productsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }



    static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewQuantity, textViewPrice;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewQuantity = itemView.findViewById(R.id.textViewQuantity);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }

    }
}