package com.example.databaseapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabase extends SQLiteOpenHelper {

    android.database.sqlite.SQLiteDatabase db;

    //Database name
    private static final String DATABASE_NAME = "Student_info";
    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database table
    private static final String TABLE_STUDENT = "tableStudent";
    //Database tableStudent columns
    private static final String KEY_ROWID = "_id";
    private static final String KEY_FIRST_NAME = "firstName";
    private static final String KEY_LAST_NAME = "lastName";

    public SQLiteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(android.database.sqlite.SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_STUDENT + "(" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_FIRST_NAME + " TEXT, " + KEY_LAST_NAME + " TEXT);";

        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
    }

    public long insertStudent(String fN, String lN) {
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_FIRST_NAME, fN);
        cv.put(KEY_LAST_NAME, lN);
        return db.insert(TABLE_STUDENT, null, cv);
    }

    public String getData() {
        //get database permission
        db = this.getReadableDatabase();
        String[] column = new String[]{KEY_ROWID, KEY_FIRST_NAME, KEY_LAST_NAME};
        //cursor = system buildin class specific table kay content pe jana ho to yeh lekr jati hai.
        Cursor cursor = db.query(TABLE_STUDENT, column, null, null, null, null, null);

        String result = "";

        int iRow = cursor.getColumnIndex(KEY_ROWID);
        int iFirstName = cursor.getColumnIndex(KEY_FIRST_NAME);
        int iLastName = cursor.getColumnIndex(KEY_LAST_NAME);

        //start from first value; till you find the last value; increment the loop
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            result = result + cursor.getString(iRow) + ". " + cursor.getString(iFirstName) + " " + cursor.getString(iLastName) + "\n";
        }
        // when we open database as we did using readableDatabase after all the work we need to close it.
        db.close();
        return result;
    }

    public String getStudentFirstName(long l) {
        db = this.getReadableDatabase();
        String[] column = new String[]{KEY_ROWID, KEY_FIRST_NAME, KEY_LAST_NAME};
        Cursor cursor = db.query(TABLE_STUDENT, column, KEY_ROWID + "=" + l, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
            String name = cursor.getString(1);
            return name;
        }
        return null;
    }

    public String getStudentLastName(long l) {
        db = this.getReadableDatabase();
        String[] column = new String[]{KEY_ROWID, KEY_FIRST_NAME, KEY_LAST_NAME};
        Cursor cursor = db.query(TABLE_STUDENT, column, KEY_ROWID + "=" + l, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
            String name = cursor.getString(2);
            return name;
        }
        return null;
    }

    public void updateStudent(long l, String fN, String lN) {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_FIRST_NAME, fN);
        contentValues.put(KEY_LAST_NAME, lN);
        db.update(TABLE_STUDENT, contentValues, KEY_ROWID + "=" + l, null);
        db.close();
    }

    public void deleteStudent(long l) {
        // id not assign to another unless you use trunk at or drop the table
        db = this.getWritableDatabase();
        db.delete(TABLE_STUDENT, KEY_ROWID + "=" + l, null);
    }
}