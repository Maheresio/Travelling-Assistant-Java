package com.example.travellingassistant;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ProductsDao  {

    @Insert
    void insert(Products product);

    @Update
    void update(Products product);

    @Delete
    void delete(Products product);

    //no function to delete all so we will use query

    @Query("DELETE From Products")
    void deleteAllProducts();

    @Query("SELECT * From Products")
    LiveData<List<Products>> getAllProducts();

}
