package com.example.travellingassistant;


import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    CardView weeklyBalanceCard;
    CardView saleTransactionsCard;
    CardView registeredStoresCard;
    CardView maintenanceRequestCard;
    CardView additionalRequestCard;
    CardView reportsCard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.purple_200)));

        weeklyBalanceCard=findViewById(R.id.card_view_weekly_balance);
        saleTransactionsCard=findViewById(R.id.card_view_sales_transaction);
        registeredStoresCard=findViewById(R.id.card_view_registered_stores);
        maintenanceRequestCard=findViewById(R.id.card_view_maintenance_request);
        additionalRequestCard=findViewById(R.id.card_view_additional_request);
        reportsCard=findViewById(R.id.card_view_reports);

        weeklyBalanceCard.setOnClickListener(v -> {
            Intent i=new Intent(MainActivity.this, WeeklyBalance.class);
            startActivity(i);
        });

        saleTransactionsCard.setOnClickListener(v -> {
            Intent i=new Intent(MainActivity.this, SaleTransactions.class);
            startActivity(i);
        });

        registeredStoresCard.setOnClickListener(v -> {
            Intent i=new Intent(MainActivity.this, StoresInList.class);
            startActivity(i);
        });

        maintenanceRequestCard.setOnClickListener(v -> {
            Intent i=new Intent(MainActivity.this, MaintenanceRequest.class);
            startActivity(i);
        });


        additionalRequestCard.setOnClickListener(v -> {
            Intent i=new Intent(MainActivity.this, AdditionalRequest.class);
            startActivity(i);
        });

        reportsCard.setOnClickListener(v -> {
            Intent i=new Intent(MainActivity.this, Reports.class);
            startActivity(i);
        });


    }
}
