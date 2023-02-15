package com.example.travellingassistant;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(tableName = "Additional_Request")
public class AdditionalRequestModel {

    @PrimaryKey (autoGenerate = true)
    int id;
    String type;
    String quantity;
    String storeName;
    String date;

    public AdditionalRequestModel(String storeName, String quantity, String type ,String date) {
        this.type = type;
        this.quantity = quantity;
        this.storeName = storeName;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
