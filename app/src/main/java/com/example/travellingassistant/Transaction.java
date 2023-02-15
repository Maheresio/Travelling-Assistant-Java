package com.example.travellingassistant;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Transactions")
public class Transaction {

    @PrimaryKey (autoGenerate = true)
    int id;
    String storeName;
    double cash;
    String productName;

    String date;

    public Transaction(String storeName, String productName, double cash, String date) {
        this.storeName = storeName;
        this.cash = cash;
        this.productName = productName;
        this.date = date;
    }


    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}




