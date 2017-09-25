package com.example.a14bpo.m4_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button loginButton;
    private Button cancelButton;
    private static boolean loggedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.inUser);
        password = (EditText) findViewById(R.id.inPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
        cancelButton = (Button) findViewById(R.id.cancelLogin);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HubActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String namein, String passin) {
        if (namein.equals("user") && passin.equals("pass")) { //HARDCODED CREDENTIALS
            Intent intent = new Intent(MainActivity.this, HubActivity.class);
            loggedIn = true;
            startActivity(intent);
        } else {
            password.setError("Error, incorrect password");
            password.requestFocus();
        }
    }

    public static boolean getLoggedin() {
        return loggedIn;
    }

    public static void setLoggenin(boolean b) {
        loggedIn = b;
    }
}
