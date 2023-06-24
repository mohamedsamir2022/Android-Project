package com.example.androidbroject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class booking extends AppCompatActivity {
    private static final String CHANNEL_ID = "channel 1";
    Button btn_car;
Button btn_hotel;
Button  btn_trip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        btn_car = findViewById(R.id.btn_car);
        btn_hotel= findViewById(R.id.btn_hotel);
        btn_trip = findViewById(R.id.btn_trip);

        btn_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent( getBaseContext(),car.class);
                startActivity(i3);
            }
        });

        btn_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3;
                i3 = new Intent( getBaseContext(),plane.class);

                startActivity(i3);
            }
        });

        btn_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent( getBaseContext(),hotel.class);

                startActivity(i3);
            }
        });
createNotificationChannel();
    }
    public void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build .VERSION_CODES.O){
            String name = " greeting";
            String  description = "this channel for  greeting notifation ";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,name , importance);
            channel.setDescription(description);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }

    }
    public  void showNotification( View v){

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_foreground);
        builder.setContentTitle("notificastions");
        builder.setContentText("showing  all android notification");
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.notify(1, builder.build());

    }





}