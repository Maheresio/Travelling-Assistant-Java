package com.example.travellingassistant;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private ProductsRepository productsRepository;
    private LiveData<List<Products>> allProducts;

    public ProductViewModel(@NonNull Application application) {
        super(application);
        productsRepository= new ProductsRepository(application);
        allProducts =productsRepository.getGetAllProducts();
    }

    public void insert(Products product)
    {
        productsRepository.insert(product);
    }
    public void update(Products product)
    {
        productsRepository.update(product);
    }
    public void delete(Products product)
    {
        productsRepository.delete(product);
    }
    public void deleteAllProducts()
    {
        productsRepository.deleteAllProducts();
    }
    public LiveData<List<Products>>getAllProducts()
    {
        return allProducts;
    }

}
