package com.example.mrityunjay.androidassignment113;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Mrityunjay on 07-06-2017.
 */

public class Employee {
    private int age;
    private  String name;
    private Bitmap image;

    public Employee(Bitmap bitmap, String name, int age){
        this.image = bitmap;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
