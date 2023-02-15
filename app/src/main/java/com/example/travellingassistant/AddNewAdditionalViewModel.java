package com.example.travellingassistant;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddNewAdditionalViewModel extends AndroidViewModel {

    private AdditionalRequestsRepository additionalRequestsRepository;

    public AddNewAdditionalViewModel (@NonNull Application application) {
        super(application);
        additionalRequestsRepository= new AdditionalRequestsRepository(application);
    }

    public void insert(AdditionalRequestModel additionalRequestModel)
    {
        additionalRequestsRepository.insert(additionalRequestModel);
    }
    public void update(AdditionalRequestModel additionalRequestModel)
    {
        additionalRequestsRepository.update(additionalRequestModel);
    }

}
