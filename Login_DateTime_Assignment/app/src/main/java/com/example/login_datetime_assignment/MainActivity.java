package com.example.login_datetime_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    DatabaseHelper db;
    Button b1, b2, dateOfBirth;
    EditText e0, e1, e2, e3;
    TextView textView;

    int day, month, year;
    int dayFinal, monthFinal, yearFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        b1 = (Button) findViewById(R.id.register);
        b2 = (Button) findViewById(R.id.button2);
        dateOfBirth = (Button) findViewById(R.id.dateOfBirth);

        e0 = (EditText) findViewById(R.id.editText);
        e1 = (EditText) findViewById(R.id.email);
        e2 = (EditText) findViewById(R.id.pass);
        e3 = (EditText) findViewById(R.id.cpass);

        textView = (TextView) findViewById(R.id.textView);

        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, MainActivity.this, year, month, day);
                datePickerDialog.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s0 = e0.getText().toString();
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = textView.getText().toString();

                if (s0.equals("") || s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("")) {
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else {
                    if (s2.equals(s3)) {
                        Boolean chkeusername = db.chkeusername(s0);
                        Boolean chkemail = db.chkemail(s1);

                        if(e2.getText().toString().length() < 8 &&! db.isValidPassword(e2.getText().toString())){
                            Toast.makeText(getApplicationContext(), "Password is Not Valid", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            // Toast.makeText(getApplicationContext(), "Password is Valid", Toast.LENGTH_SHORT).show();

                            if (chkemail && chkeusername) {
                                boolean insert = db.insert(s0, s1, s2, s4);

                                if (insert) {
                                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(getApplicationContext(), "UserName or Email is Already exists", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        yearFinal = year;
        monthFinal = month + 1;
        dayFinal = dayOfMonth;

        textView.setText(dayFinal + "/" + monthFinal + "/" + yearFinal);
        String userName = e0.getText().toString();
        String dob = textView.getText().toString();

        Intent intent = new Intent(MainActivity.this, AfterLogin.class);
        intent.putExtra("userN", userName);
        intent.putExtra("dateOfB", dob);
        startActivity(intent);
    }
}
