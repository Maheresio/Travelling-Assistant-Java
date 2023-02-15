package com.example.travellingassistant;

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


public class SaleTransactions extends AppCompatActivity {

    private TransactionViewModel transactionViewModel;

    private RecyclerView recyclerView;
    private TransactionAdapter adapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_transactions);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.purple_200)));

        recyclerView=findViewById(R.id.transaction_recyclerView);
        fab = findViewById(R.id.transaction_floatingActionButton);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new TransactionAdapter(this);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SaleTransactions.this,AddTransactionScreen.class);
                startActivityForResult(i,1);
                finish();
            }
        });

        transactionViewModel= ViewModelProviders.of(this).get(TransactionViewModel.class);
        transactionViewModel.getAllTransactions().observe(this, new Observer<List<Transaction>>() {



            @Override
            public void onChanged(List<Transaction> transactions) {
                adapter.setTransactionsList(transactions);
            }
        });




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.restore_option)
        {
            transactionViewModel.deleteAllTransactions();
        }
        else if(item.getItemId()==R.id.share_option)
        {
            double count =0;
            List<Transaction> l=adapter.getTransactionsList();
            for (int i=0;i<l.size();i++)
            {
                count += adapter.getTransactionsList().get(i).cash;
            }

            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "ahmed@gmail.com"});
            email.putExtra(Intent.EXTRA_SUBJECT,"All Transactions" );
            email.putExtra(Intent.EXTRA_TEXT,"The total of transactions is $"+String.valueOf(count));

//need this to prompts email client only
            email.setType("message/rfc822");

            startActivity(Intent.createChooser(email, "Choose an Email client :"));
        }

        return super.onOptionsItemSelected(item);
    }
}