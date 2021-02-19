package com.example.login_datetime_assignment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AfterLogin extends AppCompatActivity {

    TextView textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        String uName = intent.getStringExtra("userN");
        String uDoB = intent.getStringExtra("dateOfB");

        textView.setText("WELCOME " + uName + "! " + " Your Date of Birth is " + uDoB);
        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
    }
}