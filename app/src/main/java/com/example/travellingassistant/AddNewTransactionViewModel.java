package com.example.travellingassistant;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddNewTransactionViewModel extends AndroidViewModel {


    private TransactionRepository transactionRepository;

    public AddNewTransactionViewModel (@NonNull Application application) {
        super(application);
        transactionRepository= new TransactionRepository(application);
    }

    public void insert(Transaction transaction)
    {
        transactionRepository.insert(transaction);
    }
    public void update(Transaction transaction)
    {
        transactionRepository.update(transaction);
    }

}
