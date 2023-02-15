package com.example.travellingassistant;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MaintenanceRequestViewModel extends AndroidViewModel {

    private MaintenanceRequestsRepository maintenanceRequestsRepository;
    private LiveData<List<MaintenanceRequestModel>> allMaintenanceRequests;

    public MaintenanceRequestViewModel(@NonNull Application application) {
        super(application);
        maintenanceRequestsRepository= new MaintenanceRequestsRepository(application);
        allMaintenanceRequests =maintenanceRequestsRepository.getGetAllMaintenanceRequests();
    }

    public void insert(MaintenanceRequestModel maintenanceRequestModel)
    {
        maintenanceRequestsRepository.insert(maintenanceRequestModel);
    }
    public void update(MaintenanceRequestModel maintenanceRequestModel)
    {
        maintenanceRequestsRepository.update(maintenanceRequestModel);
    }
    public void delete(MaintenanceRequestModel maintenanceRequestModel)
    {
        maintenanceRequestsRepository.delete(maintenanceRequestModel);
    }
    public void deleteAllMaintenanceRequests()
    {
        maintenanceRequestsRepository.deleteAllMaintenanceRequests();
    }
    public LiveData<List<MaintenanceRequestModel>>getAllMaintenanceRequests()
    {
        return allMaintenanceRequests;
    }
}
