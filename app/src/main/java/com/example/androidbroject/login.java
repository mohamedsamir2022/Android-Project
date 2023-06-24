package com.example.androidbroject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    DbHelber helper;
    ImageView facebook;
    ImageView twitter;
    ImageView google;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        helper= new DbHelber(getApplicationContext());


        facebook = findViewById(R.id.facebook);
        twitter = findViewById(R.id.twitter);
        google = findViewById(R.id.google);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent();
                i2.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://www.facebook.com");
                if(i2.resolveActivity(getPackageManager()) !=null){
                startActivity(i2);
            }}
        });

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent();
                i2.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://www.twitter.com");
                if(i2.resolveActivity(getPackageManager()) !=null){
                    startActivity(i2);
                }}

        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent();
                i2.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://www.google.com");
                if(i2.resolveActivity(getPackageManager()) !=null){
                    startActivity(i2);
                }}
        });





    }
    public void login (View v ){
        EditText editTextName = findViewById(R.id.name);
        EditText editTextPhone = findViewById(R.id.phone);
        EditText editTextEmail = findViewById(R.id.email);

        String nameValue = editTextName.getText().toString();
        String phoneValue = editTextPhone.getText().toString();
        String emailValue = editTextEmail.getText().toString();


        SQLiteDatabase dp  = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values .put("name", nameValue);
        values.put("phone", phoneValue);
        values.put("email", emailValue);

        long rowNum = dp.insert("clients",null , values);
        Toast t = Toast.makeText(this   ,  rowNum + " ", Toast.LENGTH_SHORT);
        t.show();

    }
}