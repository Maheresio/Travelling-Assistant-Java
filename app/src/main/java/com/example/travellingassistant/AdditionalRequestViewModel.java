package com.example.travellingassistant;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AdditionalRequestViewModel extends AndroidViewModel {

    private AdditionalRequestsRepository additionalRequestsRepository;
    private LiveData<List<AdditionalRequestModel>> allAdditionalRequests;

    public AdditionalRequestViewModel(@NonNull Application application) {
        super(application);
        additionalRequestsRepository= new AdditionalRequestsRepository(application);
        allAdditionalRequests =additionalRequestsRepository.getGetAllAdditionalRequests();
    }

    public void insert(AdditionalRequestModel additionalRequestModel)
    {
        additionalRequestsRepository.insert(additionalRequestModel);
    }
    public void update(AdditionalRequestModel additionalRequestModel)
    {
        additionalRequestsRepository.update(additionalRequestModel);
    }
    public void delete(AdditionalRequestModel additionalRequestModel)
    {
        additionalRequestsRepository.delete(additionalRequestModel);
    }
    public void deleteAllAdditionalRequests()
    {
        additionalRequestsRepository.deleteAllAdditionalRequests();
    }
    public LiveData<List<AdditionalRequestModel>>getAllAdditionalRequests()
    {
        return allAdditionalRequests;
    }
}
