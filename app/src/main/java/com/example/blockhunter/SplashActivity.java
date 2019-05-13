package com.example.blockhunter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*************************************************************
         *************************************************************
         ****Use this to switch to your activity for testing...*******
         *************************************************************
         *************************************************************/

        startActivity(new Intent(SplashActivity.this,
                ResultsActivity.class)); //REPLACE WITH YOUR ACTIVITY CLASS(mine isn't operational yet)
        finish();
    }
}
