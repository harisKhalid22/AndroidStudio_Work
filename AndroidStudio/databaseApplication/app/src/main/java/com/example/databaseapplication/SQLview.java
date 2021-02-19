package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class SQLview extends AppCompatActivity {

    TextView textView;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_lview);

        textView = (TextView) findViewById(R.id.tvresult);
        db = new SQLiteDatabase(this);

        String data = db.getData();
        textView.setText(data);
    }
}