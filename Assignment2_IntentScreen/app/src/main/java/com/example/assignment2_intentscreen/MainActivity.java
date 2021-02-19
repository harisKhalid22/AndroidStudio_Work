package com.example.assignment2_intentscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        button  = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit1 = editText1.getText().toString();
                String edit2 = editText2.getText().toString();
                String edit3 = editText3.getText().toString();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("studentName", edit1);
                intent.putExtra("studentID", edit2);
                intent.putExtra("studentDepartment", edit3);
                startActivity(intent);
            }
        });
    }
}