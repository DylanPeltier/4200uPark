package com.example.project4200;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.ComponentActivity;


public class MainActivity extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get login button
        Button loginButton = findViewById(R.id.loginButton);
        //change page when button clicked
        loginButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));

        //get signup button
        Button signupButton = (Button) findViewById(R.id.signupButton);
        //change page when button clicked
        signupButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SignupActivity.class)));
    }

}
