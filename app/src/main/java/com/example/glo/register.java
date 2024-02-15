package com.example.glo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.regex.Pattern;
import java.lang.*;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import java.util.regex.Matcher;

public class register extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    EditText username1;
    EditText tel1;
    EditText password1;
    EditText email1;
    Button loginButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username1 = findViewById(R.id.username1);
        tel1 = findViewById(R.id.tel1);
        password1 = findViewById(R.id.password1);
        email1 = findViewById(R.id.email1);
        loginButton1 = findViewById(R.id.loginButton1);
        loginButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Username = username1.getText().toString();
                String Telephone = tel1.getText().toString();
                String Email = email1.getText().toString();
                String textPassword = password1.getText().toString();
                String emailPattern1 = "^[a-zA-Z0-9]{1,20}@[a-z0-9]{1,20}.[a-zA-Z]{2,3}$";
                String emailPattern2 = "^[a-zA-Z0-9]{1,20}@[a-z0-9]{1,20}.[a-z0-9]{1,20}.[a-zA-Z]{2,3}$";

                    if (Email.matches(emailPattern1)){
                        Toast.makeText(register.this,"Valid Mail",Toast.LENGTH_SHORT).show();
                    }
                    else if (Email.matches(emailPattern2)){
                        Toast.makeText(register.this,"Valid Mail",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(register.this,"Invalid Mail",Toast.LENGTH_SHORT).show();
                    }

                //if (emailInput.isEmpty()) {
                //    email1.setError("Field can't be empty");
                //    return false;
               // } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                 //   email1.setError("Please enter a valid email address");
                //    return false;
               // } else {
                //    email1.setError(null);
                 //   return true;
                //}

                Intent intent = new Intent(getApplicationContext(), weldone.class);

                Intent Intent = new Intent(register.this,weldone.class);
                intent.putExtra("Username",Username);
                intent.putExtra("Email",Email);
                intent.putExtra("Telephone",Telephone);

                //intent.putExtra("Password",textPassword);
                startActivity(intent);
                finish();




                if (username1.getText().toString().equals("") && password1.getText().toString().equals("")) {
                    Toast.makeText(register.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(register.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }
            }
            private boolean validateEmail() {
                String emailInput = email1.getText().toString().trim();

                if (emailInput.isEmpty()) {
                    email1.setError("Field can't be empty");
                    return false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                    email1.setError("Please enter a valid email address");
                    return false;
                } else {
                    email1.setError(null);
                    return true;
                }
            }

        });
    }
}