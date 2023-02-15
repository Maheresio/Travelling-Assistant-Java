package com.example.travellingassistant;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AdditionalRequestDao {
    @Insert
    void insert(AdditionalRequestModel additionalRequestModel);

    @Update
    void update(AdditionalRequestModel additionalRequestModel);

    @Delete
    void delete(AdditionalRequestModel additionalRequestModel);

    //no function to delete all so we will use query

    @Query("DELETE From Additional_Request")
    void deleteAllAdditionalRequests();

    @Query("SELECT * From Additional_Request")
    LiveData<List<AdditionalRequestModel>> getAllAdditionalRequests();
}
