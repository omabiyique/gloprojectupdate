package com.example.glo;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextUtils;
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




                Intent intent = new Intent(getApplicationContext(), weldone.class);

                Intent Intent = new Intent(register.this,weldone.class);
                intent.putExtra("Username",Username);
                intent.putExtra("Email",Email);
                intent.putExtra("Telephone",Telephone);

                if (TextUtils.isEmpty(username1.getText().toString())){
                    username1.setError("l'identifiant est important");
                    return;
                }
                //private boolean validateEmailAdress (EditText email1) {
                //    String emailInput =email1.getText().toString();
                //    if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
                //        Toast.makeText(register.this,"L'adresse mail est valide",Toast.LENGTH_SHORT).show();
                //    }
                //}



                if (TextUtils.isEmpty(email1.getText().toString())) {
                    email1.setError("l'email est important");
                    return;
                }

                if (TextUtils.isEmpty(tel1.getText().toString())) {
                    tel1.setError("le numero de telephone est important");
                    return;
                }

                if (TextUtils.isEmpty(password1.getText().toString())) {
                    password1.setError("le mot de passe est important");
                    return;
                }
                Toast.makeText(register.this,"Inscription reussie",Toast.LENGTH_SHORT).show();

                startActivity(intent);
                finish();

            }
        });
    };
}
