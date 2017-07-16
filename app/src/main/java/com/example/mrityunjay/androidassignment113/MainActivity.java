package com.example.mrityunjay.androidassignment113;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    ImageView imageView;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.text);
        textView2 = (TextView) findViewById(R.id.text2);
        imageView = (ImageView) findViewById(R.id.image);
        DatabaseHandler databaseHandler = new DatabaseHandler(this);

        employee = new Employee(BitmapFactory.decodeResource(getResources(), R.drawable.gingerbread), "Mritunjay", 26);

        databaseHandler.insertEmployee(employee);
        employee = databaseHandler.retrievr();

        textView1.setText(employee.getName());
        textView2.setText(Integer.toString(employee.getAge()));
        imageView.setImageBitmap(employee.getImage());

    }


}
