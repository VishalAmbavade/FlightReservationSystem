package com.example.vishal.flightreservation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class register extends AppCompatActivity {

    EditText nameEt, surnameEt, ageEt, usernameEt, passwordEt;
    String str_name, str_surname, str_age, str_username, str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEt = findViewById(R.id.et_name);
        surnameEt = findViewById(R.id.et_surname);
        ageEt = findViewById(R.id.et_age);
        usernameEt = findViewById(R.id.et_username);
        passwordEt = findViewById(R.id.et_password);

    }

    public void OnReg(View view) {
        str_name = nameEt.getText().toString();
        str_surname = surnameEt.getText().toString();
        str_age = ageEt.getText().toString();
        str_username = usernameEt.getText().toString();
        str_password = passwordEt.getText().toString();

        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_name, str_surname, str_age, str_username, str_password);
    }
}
