package com.example.travellingassistant;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Date;

@Database(entities ={Transaction.class,Products.class},exportSchema = false , version = 4)
public  abstract class TransactionRoomDb extends RoomDatabase {

    private static TransactionRoomDb instance;

    public abstract TransactionDao transactionDao();

    public static synchronized TransactionRoomDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), TransactionRoomDb.class, "transaction-database").fallbackToDestructiveMigration().addCallback(roomCallBack).build();
        }
        return instance;

    }

    private static final RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        //deal app when first time open and dealing with data base
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new TransactionRoomDb.PopulateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    private static class PopulateDataAsyncTask extends AsyncTask<Void, Void, Void> {

        private final TransactionDao transactionDao;

        public PopulateDataAsyncTask(TransactionRoomDb db) {
            transactionDao = db.transactionDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            transactionDao.insert(new Transaction("Maheresio Store","Iphone 13",500,new Date().toString()));
            transactionDao.insert(new Transaction("Maheresio Store","Iphone 13",500,new Date().toString()));
            transactionDao.insert(new Transaction("Maheresio Store","Iphone 13",500,new Date().toString()));
            return null;
        }
    }


}
