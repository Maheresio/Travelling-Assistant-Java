package com.example.travellingassistant;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StoresDao {
    @Insert
    void insert(StoreModel storeModel);

    @Update
    void update(StoreModel storeModel);

    @Delete
    void delete(StoreModel storeModel);

    //no function to delete all so we will use query

    @Query("DELETE From Stores")
    void deleteAllStores();

    @Query("SELECT * From Stores")
    LiveData<List<StoreModel>> getAllStores();
}
