package com.example.vishal.flightreservation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    public void OnReg(View view) {
        str_name = nameEt.getText().toString();
        str_surname = surnameEt.getText().toString();
        str_age = ageEt.getText().toString();
        str_username = usernameEt.getText().toString();
        str_password = passwordEt.getText().toString();

        if (isValidPassword(str_password) && str_password.length() > 8) {

            if (str_name.isEmpty() || str_username.isEmpty() || str_age.isEmpty() || str_username.isEmpty() || str_password.isEmpty()) {
                Toast.makeText(register.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            } else {
                String type = "register";
                BackgroundWorker backgroundWorker = new BackgroundWorker(this);
                backgroundWorker.execute(type, str_name, str_surname, str_age, str_username, str_password);
            }
        } else {
            passwordEt.setError("Password should contain at least 8 chars");
        }
    }
}
