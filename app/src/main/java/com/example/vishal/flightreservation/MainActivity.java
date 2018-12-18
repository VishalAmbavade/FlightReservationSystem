package com.example.vishal.flightreservation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText UserNameEt, PasswordEt;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UserNameEt = findViewById(R.id.etUserName);
        PasswordEt = findViewById(R.id.etPassword);
        login = findViewById(R.id.btn_login);

    }

    public void onLogin(View view) {
        String username = UserNameEt.getText().toString();
        String password = PasswordEt.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(MainActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
        } else {


            String type = "login";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, username, password);

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name", username);
            editor.apply();
        }


        //Intent intent = new Intent(this, temp.class);
        //startActivity(intent);
    }

    public void openReg(View view) {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }


}
