package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    TextView send_otp;
    Button login_btn;
    int counter;
    EditText enter_otp, enter_mob;
    CountDownTimer countDownTimer;

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        finish();
    }

    TextView go_to_sign_up;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        go_to_sign_up.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent in=new Intent(Login.this,Signup.class);
                startActivity(in);
                finish();

            }
        });

    }

    public  void init()
    {

        go_to_sign_up=(TextView)findViewById(R.id.go_to_sign_up);




    }




}
