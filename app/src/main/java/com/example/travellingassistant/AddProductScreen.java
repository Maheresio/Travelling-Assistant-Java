package com.example.travellingassistant;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class AddProductScreen extends AppCompatActivity {

    EditText nameEditTxt;
    EditText descEditTxt;
    EditText quantityEditTxt;
    EditText priceEditTxt;

    private AddNewProductViewModel addNewProductViewModel;
    private ProductViewModel productViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);


         nameEditTxt = findViewById(R.id.nameEditTxt);
         descEditTxt = findViewById(R.id.descEditTxt);
         quantityEditTxt = findViewById(R.id.quantityEditTxt);
         priceEditTxt = findViewById(R.id.priceEditTxt);


         addNewProductViewModel= ViewModelProviders.of(this).get(AddNewProductViewModel.class);
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
        String name=nameEditTxt.getText().toString();
        String desc=descEditTxt.getText().toString();
        String quantity=quantityEditTxt.getText().toString();
        String price= priceEditTxt.getText().toString();
        int image=getImage(name);


        if (TextUtils.isEmpty(nameEditTxt.getText().toString()) || TextUtils.isEmpty(descEditTxt.getText().toString()) ||
                TextUtils.isEmpty(quantityEditTxt.getText().toString()) || TextUtils.isEmpty(priceEditTxt.getText().toString()))
        {

            Toast.makeText(AddProductScreen.this, "Please, Fill all fields", Toast.LENGTH_SHORT).show();

        }
        else
        {

            addNewProductViewModel.insert(new Products(name,desc,Integer.parseInt(quantity),Double.parseDouble(price),getImage(name)));

            finish();

        }


    {

    }
    }

    public int getImage(String txt)
    {

        if(txt.toLowerCase().contains("samsung")&&(txt.toLowerCase().contains("phone"))||txt.toLowerCase().contains("mobile"))
    {
        return R.drawable.sumsung_mobile;
    }
       else if(txt.toLowerCase().trim().contains("iphone"))
        {
            return R.drawable.iphone_mobile;
        }
        else if(txt.toLowerCase().contains("samsung")&&(txt.toLowerCase().contains("tv")))
        {
            return R.drawable.samsung_tv;
        }
        else if(txt.toLowerCase().contains("lg")&&(txt.toLowerCase().trim().contains("tv")))
        {
            return R.drawable.lg;
        }
        else if((txt.toLowerCase().trim().contains("ps5"))||txt.toLowerCase().trim().contains("playstation5"))
        {
            return R.drawable.ps5;
        }
        else if(txt.toLowerCase().contains("apple")&&(txt.toLowerCase().contains("smart"))||txt.toLowerCase().contains("watch"))
        {
            return R.drawable.apple_smart;
        }
        else if(txt.toLowerCase().contains("huawei")&&(txt.toLowerCase().contains("smart"))||txt.toLowerCase().contains("watch"))
        {
            return R.drawable.huawei_smart;
        }
        else if(txt.toLowerCase().trim().contains("htc")||txt.toLowerCase().trim().contains("vr"))
        {
            return R.drawable.htc_vr;
        }
        return R.drawable.default_image;
    }
}


