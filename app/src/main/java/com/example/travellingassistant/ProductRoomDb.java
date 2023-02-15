package com.example.travellingassistant;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Products.class,Transaction.class}, version = 2)
public abstract class ProductRoomDb extends RoomDatabase {

    private static ProductRoomDb instance;

    public abstract ProductsDao productsDao();

    public static synchronized ProductRoomDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), ProductRoomDb.class, "product-database").fallbackToDestructiveMigration().addCallback(roomCallBack).build();
        }
        return instance;

    }

    private static final RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        //deal app when first time open and dealing with data base
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    static class PopulateDataAsyncTask extends AsyncTask<Void, Void, Void> {

        private final ProductsDao productsDao;

        public PopulateDataAsyncTask(ProductRoomDb db) {
            productsDao = db.productsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            productsDao.insert(new Products("mobile", "hello", 4, 20, R.drawable.ps5));
            productsDao.insert(new Products("mobile", "hello", 4, 20, R.drawable.ps5));
            productsDao.insert(new Products("mobile", "hello", 4, 20, R.drawable.ps5));
            return null;
        }
    }


}
