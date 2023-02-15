package com.example.travellingassistant;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Date;

@Database(entities = {StoreModel.class,MaintenanceRequestModel.class,Products.class,Transaction.class,AdditionalRequestModel.class}, version = 2)
public abstract class StoresRoomDb extends RoomDatabase {


    private static StoresRoomDb instance;

    public abstract StoresDao storesDao();

    public static synchronized StoresRoomDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), StoresRoomDb.class, "stores-database").fallbackToDestructiveMigration().addCallback(roomCallBack).build();
        }
        return instance;

    }

    private static final RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        //deal app when first time open and dealing with data base
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new StoresRoomDb.PopulateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    static class PopulateDataAsyncTask extends AsyncTask<Void, Void, Void> {

        private final StoresDao storesDao;

        public PopulateDataAsyncTask(StoresRoomDb db) {
            storesDao = db.storesDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            storesDao.insert(new StoreModel("Maheresio Store",String.valueOf(22),String.valueOf(520),"01247878454",new Date().toString()));
            storesDao.insert(new StoreModel("Maheresio Store",String.valueOf(22),String.valueOf(520),"01247878454",new Date().toString()));
            storesDao.insert(new StoreModel("Maheresio Store",String.valueOf(22),String.valueOf(520),"01247878454",new Date().toString()));

            return null;
        }
    }

}
