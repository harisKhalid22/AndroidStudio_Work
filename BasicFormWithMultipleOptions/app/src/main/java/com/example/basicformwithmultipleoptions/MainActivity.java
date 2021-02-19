package com.example.basicformwithmultipleoptions;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.bottom);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                Toast.makeText(getApplicationContext(), "Name :" + editText.getText().toString(), Toast.LENGTH_SHORT).show();

                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
                        RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

                        if (radioButton1.isChecked()) {
                            Toast.makeText(getApplicationContext(), "Male", Toast.LENGTH_SHORT).show();
                        } else if (radioButton2.isChecked()) {
                            Toast.makeText(getApplicationContext(), "Female", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Kindly Select one.", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
                final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);

                if (checkBox1.isChecked()) {
                    Toast.makeText(getApplicationContext(), "I want Apple.", Toast.LENGTH_SHORT).show();
                } else if (checkBox2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "I want Orange", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No Thanks.", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
