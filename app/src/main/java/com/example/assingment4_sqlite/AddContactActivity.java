package com.example.assingment4_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.assingment4_sqlite.MainActivity.db;

public class AddContactActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextPhone;
    EditText editTextStreet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextStreet = findViewById(R.id.editTextStreet);
    }

    public void buttonSaveContact_OnClick(View v){
        db.addContact(new Contact(editTextName.getText().toString(),
                editTextPhone.getText().toString(),
                editTextStreet.getText().toString()));

        Intent main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(main);
    }


}
