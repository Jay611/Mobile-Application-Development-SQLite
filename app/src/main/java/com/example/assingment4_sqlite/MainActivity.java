package com.example.assingment4_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler(this);
    }

    public void buttonAddContact_OnClick(View v){
        Intent intent = new Intent(getApplicationContext(), AddContactActivity.class);
        startActivity(intent);
    }

    public void buttonAllContact_OnClick(View v){
        Intent intent = new Intent(getApplicationContext(), DisplayAllContactActivity.class);
        startActivity(intent);
    }
}
