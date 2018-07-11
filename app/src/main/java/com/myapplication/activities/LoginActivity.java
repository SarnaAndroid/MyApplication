package com.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.myapplication.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    String username, password;
    private TextView tvRegister;
    private Button btnLogin;
    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        initViewsWithData();
    }

    private void initViewsWithData() {
        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
    }

    private void initViews() {
        etPassword = findViewById(R.id.et_password);
        etUsername = findViewById(R.id.et_user_name);
        btnLogin = findViewById(R.id.btn_login);
        tvRegister = findViewById(R.id.tv_register);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                if (username != null && !username.equals("")) {
                    if (password != null && !password.equals("")) {
                        if (username.equals("1234") && password.equals("1234")) {
                            Intent intent = new Intent(this, DashboardActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        etPassword.setError("Fill Correct Password");
                    }
                } else  {
                    etUsername.setError("Fill Correct Username");
                }
                break;
            case R.id.tv_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
