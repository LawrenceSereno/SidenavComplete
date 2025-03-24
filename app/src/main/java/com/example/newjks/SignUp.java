package com.example.newjks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    EditText editTextNewUsername, editTextNewPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        editTextNewUsername = findViewById(R.id.editTextNewUsername);
        editTextNewPassword = findViewById(R.id.editTextNewPassword);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newUsername = editTextNewUsername.getText().toString().trim();
                String newPassword = editTextNewPassword.getText().toString().trim();

                // Check username length (must be at least 7 characters)
                if (newUsername.length() < 7) {
                    Toast.makeText(SignUp.this, "Username must be at least 7 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check password length (must be exactly 3 or 4 characters)
                if (newPassword.length() < 3 || newPassword.length() > 4) {
                    Toast.makeText(SignUp.this, "Password must be 3 or 4 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save new user credentials
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", newUsername);
                editor.putString("password", newPassword);
                editor.apply();

                Toast.makeText(SignUp.this, "Sign-Up Successful!", Toast.LENGTH_SHORT).show();

                // Start Login Activity with Slide Animation
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

                finish();
            }
        });
    }
}
