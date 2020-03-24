package com.example.test;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.BAckgrounddata.GetData;
import com.example.test.Internet_connection.volley_for_get_category;
import com.example.test.Model.FoodModel;
import com.example.test.Sqldirectory.CartLitedb;

import java.util.ArrayList;
import java.util.HashMap;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
public class FlashScreen extends AppCompatActivity {
String url ="http://61.247.229.49:8082/biryaniweb/food";
    Button login ,signup;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        text = findViewById(R.id.text);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(ActivityCompat.checkSelfPermission(FlashScreen.this,ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(FlashScreen.this, new String[]{ACCESS_FINE_LOCATION},1);
        }



        Handler handel = new Handler();
        handel.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
               // startActivity(new Intent(FlashScreen.this,Home_Screen.class));
               // finish();


                get_cat();


            }
        },3000);

    }


    public void get_cat()
    {
        volley_for_get_category obj_cat=new volley_for_get_category();
        obj_cat.get_all_category(FlashScreen.this);
finish();
    }


}

