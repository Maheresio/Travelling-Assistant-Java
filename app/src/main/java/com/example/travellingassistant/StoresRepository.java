package com.example.travellingassistant;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StoresRepository {

    private StoresDao storesDao;

    private LiveData<List<StoreModel>> getAllStores;

    public StoresRepository(Application app) {
        StoresRoomDb db=StoresRoomDb.getInstance(app);
        storesDao=db.storesDao();
        getAllStores=storesDao.getAllStores();
    }

    public void insert (StoreModel storeModel) { new StoresRepository.InsertAsyncTask(storesDao).execute(storeModel);}
    public void update (StoreModel storeModel) {new StoresRepository.UpdateAsyncTask(storesDao).execute(storeModel);}
    public void delete (StoreModel storeModel) { new StoresRepository.DeleteAsyncTask(storesDao).execute(storeModel);}
    public LiveData<List<StoreModel>> getGetAllStores () {return getAllStores;}
    public void deleteAllStores() {new StoresRepository.DeleteAllStoresAsyncTask(storesDao).execute();}

    private static class InsertAsyncTask extends AsyncTask<StoreModel,Void,Void>
    {
        public StoresDao storesDao;

        public InsertAsyncTask(StoresDao storesDao) {
            this.storesDao = storesDao;
        }

        @Override
        protected Void doInBackground(StoreModel... storeModels) {
            storesDao.insert(storeModels[0]);
            return null;
        }
    }
    private static class DeleteAsyncTask extends AsyncTask<StoreModel,Void,Void>
    {
        public StoresDao storesDao;

        public DeleteAsyncTask(StoresDao storesDao) {
            this.storesDao = storesDao;
        }

        @Override
        protected Void doInBackground(StoreModel... storeModels) {
            storesDao.delete(storeModels[0]);
            return null;
        }
    }
    private static class UpdateAsyncTask extends AsyncTask<StoreModel,Void,Void>
    {
        public StoresDao storesDao;

        public UpdateAsyncTask(StoresDao storesDao) {
            this.storesDao = storesDao;
        }

        @Override
        protected Void doInBackground(StoreModel... storeModels) {
            storesDao.update(storeModels[0]);
            return null;
        }
    }
    private static class DeleteAllStoresAsyncTask extends AsyncTask<Void,Void,Void>
    {
        public StoresDao storesDao;

        public DeleteAllStoresAsyncTask(StoresDao storesDao) {
            this.storesDao = storesDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            storesDao.deleteAllStores();
            return null;
        }
    }
}
