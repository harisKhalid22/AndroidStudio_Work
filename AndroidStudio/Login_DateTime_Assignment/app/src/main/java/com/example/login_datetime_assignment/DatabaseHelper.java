package com.example.login_datetime_assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(username text primary key, email text, password text, dateOfBirth text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }


    //inserting in database
    public boolean insert(String username, String email, String password, String dateOfBirth){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("dateOfBirth", dateOfBirth);
        long ins = db.insert("user", null, contentValues);
        if (ins == -1){
            return false;
        }
        else {
            return true;
        }
    }

    //checking if username exists
    public Boolean chkeusername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username=?", new String[]{username});
        if (cursor.getCount() > 0){
            return false;
        }
        else {
            return true;
        }
    }

    //checking if email exists
    public Boolean chkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{email});
        if (cursor.getCount() > 0){
            return false;
        }
        else {
            return true;
        }
    }

    //checking the email and password
    public Boolean userEmailPassword(String username, String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where username=? and email=? and password=?", new String[]{username, email, password});
        if (cursor.getCount() > 0){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean isValidPassword(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
