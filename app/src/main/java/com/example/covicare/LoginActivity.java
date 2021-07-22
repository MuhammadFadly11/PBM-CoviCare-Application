package com.example.covicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText inputUsername, inputPassword;
    Button loginBtn;
    Button goSignUpBtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputUsername = findViewById(R.id.inputUsername);
        inputPassword = findViewById(R.id.inputPassword);
        loginBtn = findViewById(R.id.btn_login);
        goSignUpBtn = findViewById(R.id.btn_gosignup);
        db = new DBHelper(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = inputUsername.getText().toString();
                String pass = inputPassword.getText().toString();

                if (user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = db.checkUsernamePassword(user,pass);
                    if (checkuserpass == true) {
                        Toast.makeText(LoginActivity.this, "Sign In Successfull", Toast.LENGTH_SHORT).show();
                        Intent homePage = new Intent(LoginActivity.this, bottomNavigation.class);
                        startActivity(homePage);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        goSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupPage = new Intent (LoginActivity.this, RegisterActivity.class);
                startActivity(signupPage);
                finish();
            }
        });
    }
}