package com.example.cravenest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Pattern;

public class SignUP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button reg =findViewById(R.id.Registerbtn);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUP.this,MainActivity.class));
                finish();
            }
        });

        TextView back;
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(SignUP.this,MainActivity.class);
                startActivity(intent);

            }
        });

        TextView emailField = findViewById(R.id.email);
        TextView passwordField = findViewById(R.id.password);
        TextView rePasswordField = findViewById(R.id.repassword);

        String emailPattern = "^[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+$";
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";

        Button Registerbtn = findViewById(R.id.Registerbtn);
        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailField.getText().toString().isEmpty() ||
                        passwordField.getText().toString().isEmpty() ||
                        rePasswordField.getText().toString().isEmpty()) {
                    Toast.makeText(SignUP.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }

                else if(!(emailField.getText().toString().matches(emailPattern))){
                    Toast.makeText(SignUP.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
                }
                else if(!(passwordField.getText().toString().matches(passwordPattern))){
                    Toast.makeText(SignUP.this, "Password must be at least 8 characters with upper, lower, digit, and special character", Toast.LENGTH_SHORT).show();
                }
                else if(!(rePasswordField.getText().toString().equals(passwordField.getText().toString()))){
                    Toast.makeText(SignUP.this, "passwords not matches", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(SignUP.this, "Registration succeeded", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUP.this,MainActivity.class));
                }

            }
        });

    }
}