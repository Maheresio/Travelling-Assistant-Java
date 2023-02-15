package com.example.travellingassistant;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AdditionalRequestsRepository {

    private AdditionalRequestDao additionalRequestDao;

    private LiveData<List<AdditionalRequestModel>> getAllAdditionalRequests;

    public AdditionalRequestsRepository(Application app) {
        AdditionalRequestRoomDb db=AdditionalRequestRoomDb.getInstance(app);
        additionalRequestDao=db.additionalRequestDao();
        getAllAdditionalRequests=additionalRequestDao.getAllAdditionalRequests();
    }

    public void insert (AdditionalRequestModel additionalRequestModel) { new AdditionalRequestsRepository.InsertAsyncTask(additionalRequestDao).execute(additionalRequestModel);}
    public void update (AdditionalRequestModel additionalRequestModel) {new AdditionalRequestsRepository.UpdateAsyncTask(additionalRequestDao).execute(additionalRequestModel);}
    public void delete (AdditionalRequestModel additionalRequestModel) { new AdditionalRequestsRepository.DeleteAsyncTask(additionalRequestDao).execute(additionalRequestModel);}
    public LiveData<List<AdditionalRequestModel>> getGetAllAdditionalRequests () {return getAllAdditionalRequests;}
    public void deleteAllAdditionalRequests() {new AdditionalRequestsRepository.DeleteAllAdditionalRequestsAsyncTask(additionalRequestDao).execute();}

    private static class InsertAsyncTask extends AsyncTask<AdditionalRequestModel,Void,Void>
    {
        public AdditionalRequestDao additionalRequestDao;

        public InsertAsyncTask(AdditionalRequestDao additionalRequestDao) {
            this.additionalRequestDao = additionalRequestDao;
        }

        @Override
        protected Void doInBackground(AdditionalRequestModel... additionalRequestModels) {
            additionalRequestDao.insert(additionalRequestModels[0]);
            return null;
        }
    }
    private static class DeleteAsyncTask extends AsyncTask<AdditionalRequestModel,Void,Void>
    {
        public AdditionalRequestDao additionalRequestDao;

        public DeleteAsyncTask(AdditionalRequestDao additionalRequestDao) {
            this.additionalRequestDao = additionalRequestDao;
        }

        @Override
        protected Void doInBackground(AdditionalRequestModel... additionalRequestModels) {
            additionalRequestDao.delete(additionalRequestModels[0]);
            return null;
        }
    }
    private static class UpdateAsyncTask extends AsyncTask<AdditionalRequestModel,Void,Void>
    {
        public AdditionalRequestDao additionalRequestDao;

        public UpdateAsyncTask(AdditionalRequestDao additionalRequestDao) {
            this.additionalRequestDao = additionalRequestDao;
        }

        @Override
        protected Void doInBackground(AdditionalRequestModel... additionalRequestModels) {
            additionalRequestDao.update(additionalRequestModels[0]);
            return null;
        }
    }
    private static class DeleteAllAdditionalRequestsAsyncTask extends AsyncTask<Void,Void,Void>
    {
        public AdditionalRequestDao additionalRequestDao;

        public DeleteAllAdditionalRequestsAsyncTask(AdditionalRequestDao additionalRequestDao) {
            this.additionalRequestDao = additionalRequestDao;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            additionalRequestDao.deleteAllAdditionalRequests();
            return null;
        }
    }
}
