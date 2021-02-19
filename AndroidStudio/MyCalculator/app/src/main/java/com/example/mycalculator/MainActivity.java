package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button B1, B2, B3, B4, B5, B6, B7, B8, B9;      //accessModifier dataType variableName
    private Button addition, subtraction, multiplication, division, fullStop, zero, clear, equal;
    private EditText editText;
    private float mValueOne, mValueTwo;
    private boolean cAddition, cSubtraction, cMultiplication, cDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "1");
            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "2");
            }
        });
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "3");
            }
        });
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "4");
            }
        });
        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "5");
            }
        });
        B6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "6");
            }
        });
        B7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "7");
            }
        });
        B8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "8");
            }
        });
        B9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "0");
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText == null){
                    editText.setText("");
                }
                else {
                    mValueOne = Float.parseFloat(editText.getText().toString() + "");
                    cAddition = true;
                    editText.setText(null);
                }
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText == null){
                    editText.setText("");
                }
                else{
                    mValueOne = Float.parseFloat(editText.getText().toString() + "");
                    cSubtraction = true;
                    editText.setText(null);
                }
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText == null){
                    editText.setText("");
                }
                else{
                    mValueOne = Float.parseFloat(editText.getText().toString() + "");
                    cMultiplication = true;
                    editText.setText(null);
                }
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText == null){
                    editText.setText("");
                }
                else{
                    mValueOne = Float.parseFloat(editText.getText().toString() + "");
                    cDivision = true;
                    editText.setText(null);
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueTwo = Float.parseFloat(editText.getText().toString() + "");

                if(cAddition == true){
                    editText.setText(mValueOne + mValueTwo + "");
                    cAddition = false;
                }
                if (cSubtraction == true) {
                    editText.setText(mValueOne - mValueTwo + "");
                    cSubtraction = false;
                }

                if (cMultiplication == true) {
                    editText.setText(mValueOne * mValueTwo + "");
                    cMultiplication = false;
                }

                if (cDivision == true) {
                    editText.setText(mValueOne / mValueTwo + "");
                    cDivision = false;
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

        fullStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + ".");
            }
        });
    }

    private void setupUIViews() {
        B1 = (Button) findViewById(R.id.button1);
        B2 = (Button) findViewById(R.id.button2);
        B3 = (Button) findViewById(R.id.button3);
        B4 = (Button) findViewById(R.id.button4);
        B5 = (Button) findViewById(R.id.button5);
        B6 = (Button) findViewById(R.id.button6);
        B7 = (Button) findViewById(R.id.button7);
        B8 = (Button) findViewById(R.id.button8);
        B9 = (Button) findViewById(R.id.button9);
        addition = (Button) findViewById(R.id.buttonadd);
        subtraction = (Button) findViewById(R.id.buttonsub);
        multiplication = (Button) findViewById(R.id.buttonmul);
        division = (Button) findViewById(R.id.buttondiv);
        fullStop = (Button) findViewById(R.id.button10);
        zero = (Button) findViewById(R.id.button0);
        clear = (Button) findViewById(R.id.buttonC);
        equal = (Button) findViewById(R.id.buttoneql);
        editText = (EditText) findViewById(R.id.edt1);
    }
}