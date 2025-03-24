package com.example.newjks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button btnLogin, btnGoToSignUp;
    SharedPreferences userPreferences, adminPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoToSignUp = findViewById(R.id.btnGoToSignUp);

        // SharedPreferences for users and admin
        userPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        adminPreferences = getSharedPreferences("AdminPrefs", MODE_PRIVATE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = editTextUsername.getText().toString().trim();
                String inputPassword = editTextPassword.getText().toString().trim();

                // Hardcoded Admin Credentials
                String adminUsername = "admin";
                String adminPassword = "123";

                // Retrieve stored user credentials
                String storedUsername = userPreferences.getString("username", "");
                String storedPassword = userPreferences.getString("password", "");

                if (inputUsername.equals(adminUsername) && inputPassword.equals(adminPassword)) {
                    // Admin login
                    Intent intent = new Intent(Login.this, MainActivity2.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
                    finish();
                } else if (inputUsername.equals(storedUsername) && inputPassword.equals(storedPassword)) {
                    // Regular user login
                    Toast.makeText(Login.this, "User Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Buttonnav.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                    finish();
                } else {
                    // Invalid credentials
                    Toast.makeText(Login.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGoToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
            }
        });
    }
}
