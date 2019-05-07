package com.example.blockhunter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                finish();
            }
        };

        Timer opening = new Timer();
        opening.schedule(task, 2000);

    }
}
