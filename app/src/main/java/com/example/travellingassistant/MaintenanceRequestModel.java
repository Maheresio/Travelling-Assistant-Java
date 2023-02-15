package com.example.travellingassistant;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Maintenance_Request")
public class MaintenanceRequestModel {

    @PrimaryKey (autoGenerate = true)
    int id;
    String storeName;
    String productName;
    String flaw;
    String desc;
    String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public MaintenanceRequestModel(String storeName, String productName, String flaw, String desc) {
        this.storeName = storeName;
        this.productName = productName;
        this.flaw = flaw;
        this.desc = desc;
        this.answer = answer;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFlaw() {
        return flaw;
    }

    public void setFlaw(String flaw) {
        this.flaw = flaw;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
