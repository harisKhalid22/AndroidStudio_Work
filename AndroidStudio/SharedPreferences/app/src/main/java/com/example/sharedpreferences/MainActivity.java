package com.example.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText myInput, myPassword;
    TextView textView;
    Button add, display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myInput = (EditText) findViewById(R.id.editText1);
        myPassword = (EditText) findViewById(R.id.editText2);
        textView = (TextView) findViewById(R.id.textView);
        add = (Button) findViewById(R.id.button1);
        display = (Button) findViewById(R.id.button2);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("userName", myInput.getText().toString());
                editor.putString("password", myPassword.getText().toString());
                editor.apply();

                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                String name = sharedPreferences.getString("userName", "");
                String password = sharedPreferences.getString("password", "");

                textView.setText(name + " " + password);
            }
        });
    }
}