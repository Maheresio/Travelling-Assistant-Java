package com.example.travellingassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddAdditional extends AppCompatActivity {

    EditText storeNameEditTxt;
    EditText productNameEditTxt;
    EditText quantityEditTxt;
    EditText dateEditTxt;
    Calendar calendar;

    private AddNewAdditionalViewModel addNewAdditionalViewModel;
    private AdditionalRequestViewModel additionalRequestViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_additional_request);


        storeNameEditTxt = findViewById(R.id.add_additional_storeNameEditTxt);
        productNameEditTxt = findViewById(R.id.add_additional_productNameEditTxt);
        quantityEditTxt = findViewById(R.id.add_additional_quantity_EditTxt);
        dateEditTxt = findViewById(R.id.add_additional_dateEditTxt);



        calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                updateCalender();

            }
            private  void updateCalender()
            {
                String Format="MM/dd/yy";
                SimpleDateFormat sdf=new SimpleDateFormat(Format, Locale.US);
                dateEditTxt.setText(sdf.format(calendar.getTime()));

            }
        };
        dateEditTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(AddAdditional.this,dateSetListener,calendar.get(Calendar.YEAR),Calendar.MONTH,Calendar.DAY_OF_MONTH).show();
            }
        });

        addNewAdditionalViewModel= ViewModelProviders.of(this).get(AddNewAdditionalViewModel.class);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater m=getMenuInflater();
        m.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_product) {
            saveProduct();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void saveProduct()
    {
        String storeName=storeNameEditTxt.getText().toString();
        String productName=productNameEditTxt.getText().toString();
        String quantity=quantityEditTxt.getText().toString();
        String date= dateEditTxt.getText().toString();





        if (TextUtils.isEmpty(storeNameEditTxt.getText().toString()) || TextUtils.isEmpty(productNameEditTxt.getText().toString()) ||
                TextUtils.isEmpty(quantityEditTxt.getText().toString()) || TextUtils.isEmpty(dateEditTxt.getText().toString()))
        {

            Toast.makeText(AddAdditional.this, "Please, Fill all fields", Toast.LENGTH_SHORT).show();

        }
        else
        {
//            List<Transaction> transactionList= (List<Transaction>) transactionViewModel.getAllTransactions();


            addNewAdditionalViewModel.insert(new AdditionalRequestModel(storeName,productName,quantity,date));

            finish();

        }


        {

        }
    }
}