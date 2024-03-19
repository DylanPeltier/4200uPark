package com.example.project4200;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends MainActivity {
    private EditText emailEdit, passwordEdit;
    private Button loginBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        emailEdit = findViewById(R.id.editTextTextEmailAddress);
        passwordEdit = findViewById(R.id.editTextPassword);
        loginBtn = findViewById(R.id.loginBtn);

        dbHandler = new DBHandler(LoginActivity.this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Missing Information!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (dbHandler.validateUser(email, password)) {
                    Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Login!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
