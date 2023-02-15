package com.example.travellingassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class AddMaintenanceRequest extends AppCompatActivity {

    private AddNewMaintenanceViewModel addNewMaintenanceViewModel;

    EditText storeNameEditTxt;
    EditText productNameEditTxt;
    EditText flawEditTxt;
    EditText descEditTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_maintenance_request);

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.problems_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        final String[] item = new String[1];

//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                item[0] = adapterView.getContext().getText(i).toString();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

         storeNameEditTxt=findViewById(R.id.add_Maintenance_storeNameEditTxt);
         productNameEditTxt=findViewById(R.id.add_Maintenance_productNameEditTxt);
         flawEditTxt=findViewById(R.id.add_Maintenance_flaw_EditTxt);
         descEditTxt=findViewById(R.id.add_Maintenance_descEditTxt);
        addNewMaintenanceViewModel= ViewModelProviders.of(this).get(AddNewMaintenanceViewModel.class);

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
        String flaw=flawEditTxt.getText().toString();
        String desc= descEditTxt.getText().toString();





        if (TextUtils.isEmpty(storeNameEditTxt.getText().toString()) || TextUtils.isEmpty(productNameEditTxt.getText().toString()) ||
                TextUtils.isEmpty(flawEditTxt.getText().toString()) || TextUtils.isEmpty(descEditTxt.getText().toString()))
        {

            Toast.makeText(AddMaintenanceRequest.this, "Please, Fill all fields", Toast.LENGTH_SHORT).show();

        }
        else
        {

            addNewMaintenanceViewModel.insert(new MaintenanceRequestModel(storeName,productName,flaw,desc));

            finish();

        }


        {

        }
    }

}
