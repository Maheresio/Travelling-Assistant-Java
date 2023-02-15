package com.example.travellingassistant;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddNewMaintenanceViewModel extends AndroidViewModel {



    private MaintenanceRequestsRepository maintenanceRequestsRepository;

    public AddNewMaintenanceViewModel (@NonNull Application application) {
        super(application);
        maintenanceRequestsRepository= new MaintenanceRequestsRepository(application);
    }

    public void insert(MaintenanceRequestModel maintenanceRequestModel)
    {
        maintenanceRequestsRepository.insert(maintenanceRequestModel);
    }
    public void update(MaintenanceRequestModel maintenanceRequestModel)
    {
        maintenanceRequestsRepository.update(maintenanceRequestModel);
    }

}
