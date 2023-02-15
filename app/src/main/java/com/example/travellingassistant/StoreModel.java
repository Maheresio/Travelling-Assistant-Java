package com.example.travellingassistant;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Stores")
public class StoreModel {

    @PrimaryKey(autoGenerate = true)
    int id;
    String storeName;
    String longitude;
    String latitude;
    String phone;
    String lastVisitDate;

    public StoreModel(String storeName, String longitude, String latitude, String phone, String lastVisitDate) {
        this.storeName = storeName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.phone = phone;
        this.lastVisitDate = lastVisitDate;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(String lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }
}
