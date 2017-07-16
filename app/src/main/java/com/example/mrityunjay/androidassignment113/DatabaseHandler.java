package com.example.mrityunjay.androidassignment113;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;


import java.util.jar.Attributes;

import static android.R.attr.name;
import static android.R.attr.version;

/**
 * Created by Mrityunjay on 04-06-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String DATABASE_NAME = "employee_detail";

    // Contacts table name
    private static final String TABLE_EMPLOYEE = "employee";

    // Contacts Table Columns names
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_IMAGE = "image";
    private static final String AGE = "age";
    private static final String employee = "employee.db";

    public DatabaseHandler(Context context) {
        super(context, employee, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        String qwary = "CREATE TABLE " + TABLE_EMPLOYEE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + KEY_NAME + " TEXT," + AGE + " INTEGER," + KEY_IMAGE + " BLOB" + ")";
        Log.d("Query: ", qwary);
        db.execSQL(qwary);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);

        // Create tables again
        onCreate(db);

    }

    public void insertEmployee(Employee employee) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME, employee.getName());
        contentValues.put(AGE, employee.getAge());
        contentValues.put(KEY_IMAGE, ImageConverter.getBytes(employee.getImage()));
        this.getWritableDatabase().insertOrThrow(TABLE_EMPLOYEE, "", contentValues);


    }

    public Employee retrievr() throws SQLException {
        Cursor cur = this.getWritableDatabase().query(true, TABLE_EMPLOYEE, new String[]{KEY_IMAGE,
                KEY_NAME, AGE}, null, null, null, null, null, null);
        if (cur.moveToFirst()) {
            byte[] blob = cur.getBlob(cur.getColumnIndex(KEY_IMAGE));
            String name = cur.getString(cur.getColumnIndex(KEY_NAME));
            int age = cur.getInt(cur.getColumnIndex(AGE));
            cur.close();
            return new Employee(ImageConverter.getPhoto(blob), name, age);
        }
        cur.close();
        return null;


    }
}


