package com.example.travellingassistant;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TransactionViewModel extends AndroidViewModel {

    private final TransactionRepository transactionRepository;
    private final LiveData<List<Transaction>> allTransactions;

    public TransactionViewModel(@NonNull Application application) {
        super(application);
        transactionRepository= new TransactionRepository(application);
        allTransactions =transactionRepository.getGetAllTransactions();
    }

    public void insert(Transaction transaction)
    {
        transactionRepository.insert(transaction);
    }
    public void update(Transaction transaction)
    {
        transactionRepository.update(transaction);
    }
    public void delete(Transaction transaction)
    {
        transactionRepository.delete(transaction);
    }
    public void deleteAllTransactions()
    {
        transactionRepository.deleteAllTransactions();
    }
    public LiveData<List<Transaction>>getAllTransactions()
    {
        return allTransactions;
    }

}
