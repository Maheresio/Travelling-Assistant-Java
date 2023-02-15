package com.example.travellingassistant;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AddNewProductViewModel extends AndroidViewModel {

    private ProductsRepository productsRepository;

    public AddNewProductViewModel (@NonNull Application application) {
        super(application);
        productsRepository= new ProductsRepository(application);
    }

    public void insert(Products product)
    {
        productsRepository.insert(product);
    }
    public void update(Products product)
    {
        productsRepository.update(product);
    }



}
