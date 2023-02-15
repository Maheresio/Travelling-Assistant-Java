package com.example.travellingassistant;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MaintenanceRequestsRepository {

    private MaintenanceRequestDoa maintenanceRequestDoa;

    private LiveData<List<MaintenanceRequestModel>> getAllMaintenanceRequests;

    public MaintenanceRequestsRepository(Application app) {
        MaintenanceRequestsRoomDb db=MaintenanceRequestsRoomDb.getInstance(app);
        maintenanceRequestDoa=db.maintenanceRequestDoa();
        getAllMaintenanceRequests=maintenanceRequestDoa.getAllMaintenanceRequests();
    }

    public void insert (MaintenanceRequestModel maintenanceRequestModel) { new MaintenanceRequestsRepository.InsertAsyncTask(maintenanceRequestDoa).execute(maintenanceRequestModel);}
    public void update (MaintenanceRequestModel maintenanceRequestModel) {new MaintenanceRequestsRepository.UpdateAsyncTask(maintenanceRequestDoa).execute(maintenanceRequestModel);}
    public void delete (MaintenanceRequestModel maintenanceRequestModel) { new MaintenanceRequestsRepository.DeleteAsyncTask(maintenanceRequestDoa).execute(maintenanceRequestModel);}
    public LiveData<List<MaintenanceRequestModel>> getGetAllMaintenanceRequests () {return getAllMaintenanceRequests;}
    public void deleteAllMaintenanceRequests() {new MaintenanceRequestsRepository.DeleteAllMaintenanceRequestsAsyncTask(maintenanceRequestDoa).execute();}

    private static class InsertAsyncTask extends AsyncTask<MaintenanceRequestModel,Void,Void>
    {
        public MaintenanceRequestDoa maintenanceRequestDoa;

        public InsertAsyncTask(MaintenanceRequestDoa maintenanceRequestDoa) {
            this.maintenanceRequestDoa = maintenanceRequestDoa;
        }

        @Override
        protected Void doInBackground(MaintenanceRequestModel... maintenanceRequestModels) {
            maintenanceRequestDoa.insert(maintenanceRequestModels[0]);
            return null;
        }
    }
    private static class DeleteAsyncTask extends AsyncTask<MaintenanceRequestModel,Void,Void>
    {
        public MaintenanceRequestDoa maintenanceRequestDoa;

        public DeleteAsyncTask(MaintenanceRequestDoa maintenanceRequestDoa) {
            this.maintenanceRequestDoa = maintenanceRequestDoa;
        }

        @Override
        protected Void doInBackground(MaintenanceRequestModel... MaintenanceRequestModel) {
            maintenanceRequestDoa.delete(MaintenanceRequestModel[0]);
            return null;
        }
    }
    private static class UpdateAsyncTask extends AsyncTask<MaintenanceRequestModel,Void,Void>
    {
        public MaintenanceRequestDoa maintenanceRequestDoa;

        public UpdateAsyncTask(MaintenanceRequestDoa maintenanceRequestDoa) {
            this.maintenanceRequestDoa = maintenanceRequestDoa;
        }

        @Override
        protected Void doInBackground(MaintenanceRequestModel... maintenanceRequestModels) {
            maintenanceRequestDoa.update(maintenanceRequestModels[0]);
            return null;
        }
    }
    private static class DeleteAllMaintenanceRequestsAsyncTask extends AsyncTask<Void,Void,Void>
    {
        public MaintenanceRequestDoa maintenanceRequestDoa;

        public DeleteAllMaintenanceRequestsAsyncTask(MaintenanceRequestDoa maintenanceRequestDoa) {
            this.maintenanceRequestDoa = maintenanceRequestDoa;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            maintenanceRequestDoa.deleteAllMaintenanceRequests();
            return null;
        }
    }
}
