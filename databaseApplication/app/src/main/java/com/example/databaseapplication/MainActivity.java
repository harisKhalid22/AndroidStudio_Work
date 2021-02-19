package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText firstName, lastName, id;
    Button insert, view, search, update, delete;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.editFirstName);
        lastName = (EditText) findViewById(R.id.editLastName);
        id = (EditText) findViewById(R.id.editId);

        insert = (Button) findViewById(R.id.btnInsert);
        view = (Button) findViewById(R.id.btnView);
        search = (Button) findViewById(R.id.btnSearch);
        update = (Button) findViewById(R.id.btnUpdate);
        delete = (Button) findViewById(R.id.btnDelete);

        insert.setOnClickListener(this);
        view.setOnClickListener(this);
        search.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        db = new SQLiteDatabase(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInsert:

                boolean fine = true;
                try {
                    String fN = firstName.getText().toString();
                    String lN = lastName.getText().toString();
                    db.insertStudent(fN, lN);
                }
                catch (Exception e) {
                    fine = false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }
                finally {
                    if(fine){
                        Dialog d = new Dialog(this);
                        d.setTitle("Atlast we did it");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;

            case R.id.btnView:
                    Intent intent = new Intent(getApplicationContext(), SQLview.class);
                    startActivity(intent);
                break;

            case R.id.btnSearch:

                boolean fine1 = true;
                try {
                    String myId = id.getText().toString();
                    long l = Long.parseLong(myId);
                    String fName = db.getStudentFirstName(l);
                    String lName = db.getStudentLastName(l);

                    firstName.setText(fName);
                    lastName.setText(lName);
                }
                catch (Exception e) {
                    fine1 = false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }
                finally {
                    if(fine1){
                        Dialog d = new Dialog(this);
                        d.setTitle("Atlast we did it");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;

            case R.id.btnUpdate:

                boolean fine2 = true;
                try {
                    String fN = firstName.getText().toString();
                    String lN = lastName.getText().toString();
                    String myId = id.getText().toString();
                    long l = Long.parseLong(myId);

                    db.updateStudent(l, fN, lN);
                }
                catch (Exception e) {
                    fine2 = false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }
                finally {
                    if(fine2){
                        Dialog d = new Dialog(this);
                        d.setTitle("Atlast we did it");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;

            case R.id.btnDelete:

                boolean fine3 = true;
                try {
                    String myId = id.getText().toString();
                    long l = Long.parseLong(myId);
                    db.deleteStudent(l);

                }
                catch (Exception e) {
                    fine3 = false;
                    String error = e.toString();
                    Dialog d = new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv = new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }
                finally {
                    if(fine3){
                        Dialog d = new Dialog(this);
                        d.setTitle("Atlast we did it");
                        TextView tv = new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }
                }
                break;
        }
    }
}
