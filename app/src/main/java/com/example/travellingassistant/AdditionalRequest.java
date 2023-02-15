package com.example.travellingassistant;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;


public class AdditionalRequest extends AppCompatActivity {

    private AdditionalRequestViewModel additionalRequestViewModel;

    private AdditionalRequestAdapter adapter;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_request);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.purple_200)));


        fab = findViewById(R.id.additionalRequest_floatingActionButton);
        RecyclerView recyclerView = findViewById(R.id.additionalRequest_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new AdditionalRequestAdapter(this);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(v -> {
            Intent i=new Intent(AdditionalRequest.this,AddAdditional.class);
            startActivityForResult(i,1);
            finish();
        });

        additionalRequestViewModel= ViewModelProviders.of(this).get(AdditionalRequestViewModel.class);
        additionalRequestViewModel.getAllAdditionalRequests().observe(this, additionalRequestModels -> adapter.setAdditionalRequestList(additionalRequestModels));







    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.resetmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        additionalRequestViewModel.deleteAllAdditionalRequests();
        return super.onOptionsItemSelected(item);
    }
}