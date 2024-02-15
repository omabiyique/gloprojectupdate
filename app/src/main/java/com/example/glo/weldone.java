package com.example.glo;

import static com.example.glo.R.id.buttonclose;
import static com.example.glo.R.id.username1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.*;

public class weldone extends AppCompatActivity {

    EditText username1,email1,password1,tel1;
    Button loginButton1;
    Button buttonclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weldone);

        username1 = findViewById(R.id.username1);
        email1 = findViewById(R.id.email1);
        password1 = findViewById(R.id.password1);
        tel1 = findViewById(R.id.tel1);
        loginButton1 = findViewById(R.id.loginButton1);
        buttonclose = findViewById(R.id.buttonclose);

        String Username = " "+ getIntent().getExtras().getString("Username");
        String Email = " " + getIntent().getExtras().getString("Email");
        String textPassword = " " + getIntent().getExtras().getString("textPassword");
        String Telephone = " " + getIntent().getExtras().getString("Telephone");

        username1.setText(Username);
        email1.setText(Email);
        password1.setText(textPassword);
        tel1.setText(Telephone);

        buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        loginButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(weldone.this,register.class);
                startActivity(intent);


            }

        });

    }
}