package com.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.myapplication.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvLogin;

    private Button btnRegister;

    private EditText etName, etEmail, etUsername, etPassword, etConfirmPassword;
    String name, email, username, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        initViewsWithData();


    }

    private void initViewsWithData() {

        btnRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);

    }

    private void initViews() {

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etUsername = findViewById(R.id.et_user_name);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        btnRegister = findViewById(R.id.btn_register);
        tvLogin = findViewById(R.id.tv_login);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_register:
                name = etName.getText().toString();
                email = etEmail.getText().toString();
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                confirmPassword = etConfirmPassword.getText().toString();

                if (isDataValidate()){
                    Toast.makeText(this, "Congrats You are Registered", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }


                break;
            case R.id.tv_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    private boolean isDataValidate() {
        if (name == null || name.equals("")) {
            etName.setError("Fill Correct Name");

        } else if (email == null || email.equals("")) {
            etEmail.setError("Fill Correct Email");

        } else if (username == null || username.equals("")) {
            etUsername.setError("Fill Correct Username");

        } else if (password == null || password.equals("")) {
            etPassword.setError("Fill Correct Password");

        } else if (confirmPassword == null || confirmPassword.equals("")) {
            etConfirmPassword.setError("Fill Correct Password");

        } else if (!confirmPassword.equals(password)){
            etConfirmPassword.setError("Confirm Password not match");

        }else{
            return true;
        }
        return false;
    }
}