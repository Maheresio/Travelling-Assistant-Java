package com.example.travellingassistant;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {MaintenanceRequestModel.class,Products.class,Transaction.class,AdditionalRequestModel.class,StoreModel.class}, version = 2)
public abstract class MaintenanceRequestsRoomDb extends RoomDatabase {

    private static MaintenanceRequestsRoomDb instance;

    public abstract MaintenanceRequestDoa maintenanceRequestDoa();

    public static synchronized MaintenanceRequestsRoomDb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), MaintenanceRequestsRoomDb.class, "maintenance-request-database").fallbackToDestructiveMigration().addCallback(roomCallBack).build();
        }
        return instance;

    }

    private static final RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback() {
        //deal app when first time open and dealing with data base
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new MaintenanceRequestsRoomDb.PopulateDataAsyncTask(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    static class PopulateDataAsyncTask extends AsyncTask<Void, Void, Void> {

        private final MaintenanceRequestDoa maintenanceRequestDoa;

        public PopulateDataAsyncTask(MaintenanceRequestsRoomDb db) {
            maintenanceRequestDoa = db.maintenanceRequestDoa();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            maintenanceRequestDoa.insert(new MaintenanceRequestModel("Maheresio Store","playstation 5","energy","it burned"));
            maintenanceRequestDoa.insert(new MaintenanceRequestModel("Maheresio Store","playstation 5","energy","it burned"));
            maintenanceRequestDoa.insert(new MaintenanceRequestModel("Maheresio Store","playstation 5","energy","it burned"));
            maintenanceRequestDoa.insert(new MaintenanceRequestModel("Maheresio Store","playstation 5","energy","it burned"));
            maintenanceRequestDoa.insert(new MaintenanceRequestModel("Maheresio Store","playstation 5","energy","it burned"));
            maintenanceRequestDoa.insert(new MaintenanceRequestModel("Maheresio Store","playstation 5","energy","it burned"));
            maintenanceRequestDoa.insert(new MaintenanceRequestModel("Maheresio Store","playstation 5","energy","it burned"));

            return null;
        }
    }

}
