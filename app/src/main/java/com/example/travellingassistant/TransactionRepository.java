package com.example.travellingassistant;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TransactionRepository {

    private final TransactionDao transactionDao;

    private final LiveData<List<Transaction>> getAllTransactions;

    public TransactionRepository(Application app) {
        TransactionRoomDb db=TransactionRoomDb.getInstance(app);
        transactionDao=db.transactionDao();
        getAllTransactions=transactionDao.getAllTransactions();
    }

    public void insert (Transaction transaction) { new TransactionRepository.InsertAsyncTask(transactionDao).execute(transaction);}
    public void update (Transaction transaction) {new TransactionRepository.UpdateAsyncTask(transactionDao).execute(transaction);}
    public void delete (Transaction transaction) { new TransactionRepository.DeleteAsyncTask(transactionDao).execute(transaction);}
    public LiveData<List<Transaction>> getGetAllTransactions () {return getAllTransactions;}
    public void deleteAllTransactions() {new TransactionRepository.DeleteAllTransactionsAsyncTask(transactionDao).execute();}

    private static class InsertAsyncTask extends AsyncTask<Transaction,Void,Void>
    {
        public TransactionDao transactionDao;

        public InsertAsyncTask(TransactionDao transactionDao) {
            this.transactionDao = transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.insert(transactions[0]);
            return null;
        }
    }
    private static class DeleteAsyncTask extends AsyncTask<Transaction,Void,Void>
    {
        public TransactionDao transactionDao;

        public DeleteAsyncTask(TransactionDao transactionDao) {
            this.transactionDao = transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.delete(transactions[0]);
            return null;
        }
    }
    private static class UpdateAsyncTask extends AsyncTask<Transaction,Void,Void>
    {
        public TransactionDao transactionDao;

        public UpdateAsyncTask(TransactionDao transactionDao) {
            this.transactionDao = transactionDao;
        }

        @Override
        protected Void doInBackground(Transaction... transactions) {
            transactionDao.update(transactions[0]);
            return null;
        }
    }
    private static class DeleteAllTransactionsAsyncTask extends AsyncTask<Void,Void,Void>
    {
        public TransactionDao transactionDao;

        public DeleteAllTransactionsAsyncTask(TransactionDao transactionDao) {
            this.transactionDao = transactionDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            transactionDao.deleteAllTransactions();
            return null;
        }
    }
}
