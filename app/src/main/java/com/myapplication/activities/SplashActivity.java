package com.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.myapplication.R;
import com.myapplication.utils.CurrentSession;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> {
            /* Create an Intent that will start the Menu-Activity. */
            if(new CurrentSession(this).getUserData() != null){
                Toast.makeText(this, "Welcome "+ new CurrentSession(this).getUserData().getName(),
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, DashboardActivity.class);
                SplashActivity.this.startActivity(intent);
            }else {

                Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                SplashActivity.this.startActivity(mainIntent);
            }
            SplashActivity.this.finish();
        }, 2000);
    }
}
