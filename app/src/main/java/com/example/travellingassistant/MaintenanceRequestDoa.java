package com.example.travellingassistant;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao

public interface MaintenanceRequestDoa {
    @Insert
    void insert(MaintenanceRequestModel maintenanceRequestModel);

    @Update
    void update(MaintenanceRequestModel maintenanceRequestModel);

    @Delete
    void delete(MaintenanceRequestModel maintenanceRequestModel);

    //no function to delete all so we will use query

    @Query("DELETE From Maintenance_Request")
    void deleteAllMaintenanceRequests();

    @Query("SELECT * From Maintenance_Request")
    LiveData<List<MaintenanceRequestModel>> getAllMaintenanceRequests();
}
