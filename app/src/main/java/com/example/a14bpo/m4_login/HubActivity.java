package com.example.a14bpo.m4_login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HubActivity extends AppCompatActivity {
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);

        loginButton = (Button) findViewById(R.id.logButton);

        if (MainActivity.getLoggedin()) {
            loginButton.setText("Logout");
        }

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HubActivity.this, MainActivity.class);
                MainActivity.setLoggenin(false);
                startActivity(intent);
            }
        });
    }
}
