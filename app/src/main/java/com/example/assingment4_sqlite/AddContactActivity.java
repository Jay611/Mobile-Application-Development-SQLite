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
    TextView errorTextView;
    Contact ContactInfo;

    boolean isNewContact = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextStreet = findViewById(R.id.editTextStreet);
        errorTextView = findViewById(R.id.errorTextView);
        Intent contact = getIntent();
        ContactInfo = (Contact)contact.getSerializableExtra("ContactInfo");
        if((ContactInfo) != null){
            isNewContact = false;
            editTextName.setText(ContactInfo.getName());
            editTextPhone.setText(ContactInfo.getPhoneNumber());
            editTextStreet.setText((ContactInfo.getStreet()));
        }
    }

    public void buttonSaveContact_OnClick(View v){
        if(editTextName.getText().toString().isEmpty()){
            errorTextView.setText("'Name' is required");
        } else{
            if(isNewContact){
                db.addContact(new Contact(editTextName.getText().toString(),
                        editTextPhone.getText().toString(),
                        editTextStreet.getText().toString()));
            }
            else{
                ContactInfo.setName(editTextName.getText().toString());
                ContactInfo.setPhoneNumber(editTextPhone.getText().toString());
                ContactInfo.setStreet(editTextStreet.getText().toString());
                db.updateContact(ContactInfo);
            }

            Intent main = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(main);
        }

    }

    public void buttonCancel_OnClick(View v){
        Intent main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(main);
    }

}
