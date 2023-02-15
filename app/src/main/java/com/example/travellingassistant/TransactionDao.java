package com.example.travellingassistant;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TransactionDao {


    @Insert
    void insert(Transaction transaction);

    @Update
    void update(Transaction transaction);

    @Delete
    void delete(Transaction transaction );

    //no function to delete all so we will use query

    @Query("DELETE From Transactions")
    void deleteAllTransactions();


    //observe state of table and notify live

    @Query("SELECT * From Transactions")
    LiveData<List<Transaction>> getAllTransactions();
}
