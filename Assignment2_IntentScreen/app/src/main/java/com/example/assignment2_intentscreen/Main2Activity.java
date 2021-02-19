package com.example.assignment2_intentscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textView4, textView5, textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        TextView textView6 = (TextView) findViewById(R.id.textView6);

        Intent intent = getIntent();
        String sName = intent.getStringExtra("studentName");
        String sID = intent.getStringExtra("studentID");
        String sDepartment = intent.getStringExtra("studentDepartment");

        textView4.setText("Student Name is " + sName);
        textView5.setText("Student ID is " + sID);
        textView6.setText("Student Department is " + sDepartment);
    }
}
