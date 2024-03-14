package com.example.project4200;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.ComponentActivity;


public class MainActivity extends ComponentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get login button
        Button loginButton = (Button) findViewById(R.id.loginButton);

        //get signup button
        Button signupButton = (Button) findViewById(R.id.signupButton);
    }
}
