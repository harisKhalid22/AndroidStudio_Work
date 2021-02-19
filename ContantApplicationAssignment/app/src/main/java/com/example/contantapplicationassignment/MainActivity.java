package com.example.contantapplicationassignment;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText firstName, lastName, phone, email;
    Button addContact, display;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = (EditText) findViewById(R.id.editFirstName);
        lastName = (EditText) findViewById(R.id.editLastName);
        phone = (EditText) findViewById(R.id.editPhone);
        email = (EditText) findViewById(R.id.editEmail);
        listView = (ListView) findViewById(R.id.editListView);

        addContact = (Button) findViewById(R.id.btnAddContact);
        display = (Button) findViewById(R.id.btnDisplay);

        addContact.setOnClickListener(this);
        display.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddContact:
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                intent
                .putExtra(ContactsContract.Intents.Insert.NAME, firstName.getText() + " " + lastName.getText())
                .putExtra(ContactsContract.Intents.Insert.PHONE, phone.getText())
                .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                .putExtra(ContactsContract.Intents.Insert.EMAIL, email.getText())
                .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                ;

                startActivity(intent);
                break;

            case R.id.btnDisplay:
                Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, null, null, null);
                startManagingCursor(cursor);

                String[] start = new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER,
                        ContactsContract.CommonDataKinds.Phone._ID};

                int[] end = new int[]{android.R.id.text1, android.R.id.text2};

                SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, start, end);
                listView.setAdapter(simpleCursorAdapter);
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
                break;
        }
    }
}
