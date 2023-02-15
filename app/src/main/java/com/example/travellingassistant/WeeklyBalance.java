package com.example.travellingassistant;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class WeeklyBalance extends AppCompatActivity {


private ProductViewModel productViewModel;


   private RecyclerView recyclerView;
   private ProductAdapter adapter;
     FloatingActionButton fab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_balance);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.purple_200)));


        fab = findViewById(R.id.weekly_floatingActionButton);
        recyclerView = findViewById(R.id.weekly_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ProductAdapter(this);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WeeklyBalance.this,AddProductScreen.class);
                startActivityForResult(i,1);
                finish();
            }
        });

        productViewModel= ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.getAllProducts().observe(this, new Observer<List<Products>>() {



    @Override
    public void onChanged(List<Products> products) {
        adapter.setProductsList(products);
    }
});




}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.resetmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        productViewModel.deleteAllProducts();
        return super.onOptionsItemSelected(item);
    }

}






