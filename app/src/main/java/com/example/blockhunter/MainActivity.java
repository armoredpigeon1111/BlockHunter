package com.example.blockhunter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(MainActivity.this,
                SplashActivity.class));
        /*************************************************************
         *************************************************************
         ****Use this to switch to your activity for testing...*******
         *************************************************************
         *************************************************************/


        TimerTask task = new TimerTask(){
            @Override
            public void run(){
                startActivity(new Intent(MainActivity.this,
                        ResultsActivity.class)); //REPLACE WITH YOUR ACTIVITY CLASS
            }
        };

        Timer opening = new Timer();
        opening.schedule(task, 5000);

    }


}
