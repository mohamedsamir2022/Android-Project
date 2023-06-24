package com.example.androidbroject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class car extends AppCompatActivity {
TextView location ;
TextView rlocation;
    TextView tvDate;
    EditText etDate;
    DatePickerDialog.OnDateSetListener setListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        location = findViewById(R.id.location);

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent();
                i2.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("https://goo.gl/maps/p5rav92eYCoRoZK2A");
                if(i2.resolveActivity(getPackageManager()) !=null){
                    startActivity(i2);
                }}

        });
        rlocation = findViewById(R.id.rlocation);
        rlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent();
                i2.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("https://goo.gl/maps/p5rav92eYCoRoZK2A");
                if(i2.resolveActivity(getPackageManager()) !=null){
                    startActivity(i2);
                }}

        });


tvDate = findViewById(R.id.tv_date);
etDate = findViewById(R.id.et_date);

Calendar calender = Calendar.getInstance();
        final int year= calender.get(Calendar.YEAR);
        final int month= calender.get(Calendar.MONTH);
        final int day= calender.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(

                       car.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayofmonth) {
                month = month + 1;

                String date = day + "/" + month + "/" + year;

                tvDate.setText(date);
            }
        };
        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        car.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;

                        String date = day + "/" + month + "/" + year;

                        etDate.setText(date);
                    }
                },year,month,day) ;

datePickerDialog.show();

            }
        });
        }
}


