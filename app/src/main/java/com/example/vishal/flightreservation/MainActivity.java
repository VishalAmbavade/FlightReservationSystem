package com.example.vishal.flightreservation;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText UserNameEt, PasswordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UserNameEt = findViewById(R.id.etUserName);
        PasswordEt = findViewById(R.id.etPassword);
    }

    public void onLogin(View view) {
        String username = UserNameEt.getText().toString();
        String password = PasswordEt.getText().toString();

        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);


        //Intent intent = new Intent(this, temp.class);
        //startActivity(intent);
    }

    public void openReg(View view) {
        startActivity(new Intent(this, register.class));
    }


}
