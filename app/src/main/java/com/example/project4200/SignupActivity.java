package com.example.project4200;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends MainActivity {
    private EditText firstNameEdit, lastNameEdit, emailEdit, passwordEdit;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        firstNameEdit = findViewById(R.id.editTextTextFirstName);
        lastNameEdit = findViewById(R.id.editTextTextLastName);
        emailEdit = findViewById(R.id.editTextTextEmailAddress);
        passwordEdit = findViewById(R.id.editTextPassword);
        Button signUpBtn = findViewById(R.id.signUpBtn);

        dbHandler = new DBHandler(SignupActivity.this);

        signUpBtn.setOnClickListener(view -> {
            String firstName = firstNameEdit.getText().toString();
            String lastName = lastNameEdit.getText().toString();
            String email = emailEdit.getText().toString();
            String password = passwordEdit.getText().toString();

            if (firstName.isEmpty() && lastName.isEmpty() && email.isEmpty() && password.isEmpty()) {
                Toast.makeText(SignupActivity.this, "Missing information!", Toast.LENGTH_SHORT).show();
                return;
            }


            dbHandler.addNewUser(firstName, lastName, email, password);

            Toast.makeText(SignupActivity.this, "User created! Please login!", Toast.LENGTH_SHORT).show();

            firstNameEdit.setText("");
            lastNameEdit.setText("");
            emailEdit.setText("");
            passwordEdit.setText("");

            startActivity(new Intent(SignupActivity.this, MainActivity.class));
        });

    }
}
