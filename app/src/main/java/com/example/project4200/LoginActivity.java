package com.example.project4200;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends MainActivity {
    private EditText emailEdit, passwordEdit;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        emailEdit = findViewById(R.id.editTextTextEmailAddress);
        passwordEdit = findViewById(R.id.editTextPassword);
        Button loginBtn = findViewById(R.id.loginBtn);

        dbHandler = new DBHandler(LoginActivity.this);

        loginBtn.setOnClickListener(view -> {
            String email = emailEdit.getText().toString();
            String password = passwordEdit.getText().toString();

            if (email.isEmpty() && password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Missing Information!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (dbHandler.validateUser(email, password)) {
                Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            } else {
                Toast.makeText(LoginActivity.this, "Invalid Login!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
