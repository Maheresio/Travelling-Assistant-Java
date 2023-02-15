package com.example.travellingassistant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Objects;


public class MaintenanceRequest extends AppCompatActivity {

    private MaintenanceRequestViewModel maintenanceRequestViewModel;


    private RecyclerView recyclerView;
    private MaintenanceRequestAdapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_request);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.purple_200)));


        fab = findViewById(R.id.maintenance_floatingActionButton);
        recyclerView = findViewById(R.id.maintenance_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new MaintenanceRequestAdapter(this);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MaintenanceRequest.this,AddMaintenanceRequest.class);
                startActivityForResult(i,1);
                finish();
            }
        });
        maintenanceRequestViewModel= ViewModelProviders.of(this).get(MaintenanceRequestViewModel.class);
        maintenanceRequestViewModel.getAllMaintenanceRequests().observe(this, new Observer<List<MaintenanceRequestModel>>() {
            @Override
            public void onChanged(List<MaintenanceRequestModel> maintenanceRequestModels) {
                adapter.setRequestList(maintenanceRequestModels);
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
        maintenanceRequestViewModel.deleteAllMaintenanceRequests();
        return super.onOptionsItemSelected(item);
    }
}