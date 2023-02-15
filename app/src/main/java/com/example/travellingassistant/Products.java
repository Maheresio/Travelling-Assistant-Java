package com.example.travellingassistant;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Products")
public class Products {

        @PrimaryKey(autoGenerate = true)
        private  int id;
        private final String name;
        private final String desc;
        private final int quantity;
        private final double price;
        private final int image;

    public Products( String name, String desc, int quantity, double price, int image) {
        this.name = name;
        this.desc = desc;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }

    public  void setId(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }
}

