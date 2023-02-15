package com.example.travellingassistant;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StoresViewModel extends AndroidViewModel {

    private StoresRepository storesRepository;
    private LiveData<List<StoreModel>> allStores;

    public StoresViewModel(@NonNull Application application) {
        super(application);
        storesRepository= new StoresRepository(application);
        allStores =storesRepository.getGetAllStores();
    }

    public void insert(StoreModel storeModel)
    {
        storesRepository.insert(storeModel);
    }
    public void update(StoreModel storeModel)
    {
        storesRepository.update(storeModel);
    }
    public void delete(StoreModel storeModel)
    {
        storesRepository.delete(storeModel);
    }
    public void deleteAllStores()
    {
        storesRepository.deleteAllStores();
    }
    public LiveData<List<StoreModel>>getAllStores()
    {
        return allStores;
    }
}
