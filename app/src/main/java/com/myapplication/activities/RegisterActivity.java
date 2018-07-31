package com.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.myapplication.R;
import com.myapplication.models.UserData;
import com.myapplication.utils.Constants;
import com.myapplication.utils.CurrentSession;

import java.util.Random;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private TextView tvLogin, tvErrorRG;

    private Button btnRegister;

    private EditText etName, etEmail, etMobile, etUsername,
            etPassword, etConfirmPassword;
    private RadioGroup rgUserType;
    String name, email, mobile, username, password, confirmPassword;
    int userType = 2, id;

    private UserData userData;

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
        rgUserType.setOnCheckedChangeListener(this);

    }

    private void initViews() {

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etMobile = findViewById(R.id.et_mobile);
        etUsername = findViewById(R.id.et_user_name);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        rgUserType = findViewById(R.id.radio_group);
        btnRegister = findViewById(R.id.btn_register);
        tvLogin = findViewById(R.id.tv_login);
        tvErrorRG = findViewById(R.id.tv_error_rg);
    }



    private boolean isDataValidate() {
        if (name == null || name.equals("")) {
            etName.setError("Fill Correct Name");

        } else if (email == null || email.equals("")) {
            etEmail.setError("Fill Correct Email");

        } else if (mobile == null || mobile.equals("")) {
            etMobile.setError("Fill Correct Mobile No.");

        } else if (username == null || username.equals("")) {
            etUsername.setError("Fill Correct Username");

        } else if (password == null || password.equals("")) {
            etPassword.setError("Fill Correct Password");

        } else if (confirmPassword == null || confirmPassword.equals("")) {
            etConfirmPassword.setError("Fill Correct Password");

        } else if (!confirmPassword.equals(password)){
            etConfirmPassword.setError("Confirm Password not match");

        } else if (userType == 2){
            tvErrorRG.setText(getText(R.string.user_type_error));

        } else{
            return true;
        }
        return false;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch(i){
            case R.id.radio_admin:
                userType = Constants.USER_TYPE_ADMIN;
                tvErrorRG.setText("");
                break;
            case R.id.radio_user:
                userType = Constants.USER_TYPE_USER;
                tvErrorRG.setText("");
                break;
            default:
                userType = 2;
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                name = etName.getText().toString();
                email = etEmail.getText().toString();
                mobile = etMobile.getText().toString();
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                confirmPassword = etConfirmPassword.getText().toString();
                Random random = new Random();
                id = random.nextInt();

                if (isDataValidate()){

                    userData = new UserData(id, name, username, password, mobile, userType);
                    new CurrentSession(this).setUserData(userData);
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
}