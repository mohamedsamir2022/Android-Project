package com.example.androidbroject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class hotel extends AppCompatActivity {
TextView edt;
EditText edt2 ;
Button click;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        edt = findViewById(R.id.choose);
        edt2 = findViewById(R.id.select);
        click = findViewById(R.id.clicked);

click .setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       String edt2_text = edt2.getText().toString();

        Toast.makeText(hotel.this, "number of guests is :"+ edt2_text , Toast.LENGTH_SHORT).show();
    }
});
        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("https://www.google.com/30.57749771720277");
                if(i.resolveActivity(getPackageManager()) !=null){
                    startActivity(i);
                }}

        });



    }


    }



