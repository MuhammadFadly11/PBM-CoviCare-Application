package com.example.covicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText inputUsernameRegist, inputPassword1Regist, inputPassword2Regist;
    Button signUpBtn;
    Button gosignInBtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputUsernameRegist = findViewById(R.id.inputUsernameRegist);
        inputPassword1Regist = findViewById(R.id.inputPassword1Regist);
        inputPassword2Regist = findViewById(R.id.inputPassword2Regist);
        signUpBtn = findViewById(R.id.btn_signup);
        gosignInBtn = findViewById(R.id.btn_gosignin);
        db = new DBHelper(this);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = inputUsernameRegist.getText().toString();
                String pass = inputPassword1Regist.getText().toString();
                String repass = inputPassword2Regist.getText().toString();
                
                if (user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(RegisterActivity.this,"Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = db.checkUsername(user);
                        if (checkuser == false) {
                            Boolean insert = db.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "User already exist! Please Sign In", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        gosignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInPage = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(signInPage);
                finish();
            }
        });
    }
}