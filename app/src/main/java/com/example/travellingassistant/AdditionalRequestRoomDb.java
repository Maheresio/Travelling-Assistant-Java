package com.example.travellingassistant;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Date;

@Database(entities = {AdditionalRequestModel.class,Products.class,Transaction.class,MaintenanceRequestModel.class,StoreModel.class},exportSchema = false, version = 3)
public abstract class AdditionalRequestRoomDb extends RoomDatabase {

    private static AdditionalRequestRoomDb instance;

    public abstract AdditionalRequestDao additionalRequestDao();

    public static synchronized AdditionalRequestRoomDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AdditionalRequestRoomDb.class, "additional-request-database").fallbackToDestructiveMigration().addCallback(roomCallBack).build();
        }
        return instance;

    }

    private static final RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        //deal app when first time open and dealing with data base
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new AdditionalRequestRoomDb.PopulateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    static class PopulateDataAsyncTask extends AsyncTask<Void, Void, Void> {

        private final AdditionalRequestDao additionalRequestDao;

        public PopulateDataAsyncTask(AdditionalRequestRoomDb db) {
            additionalRequestDao = db.additionalRequestDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            additionalRequestDao.insert(new AdditionalRequestModel("Maheresio Store",String.valueOf(5),"Mobile",new Date().toString()));
            additionalRequestDao.insert(new AdditionalRequestModel("Maheresio Store",String.valueOf(5),"Mobile",new Date().toString()));
            additionalRequestDao.insert(new AdditionalRequestModel("Maheresio Store",String.valueOf(5),"Mobile",new Date().toString()));

            return null;
        }
    }

}
