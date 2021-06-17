package com.techzone.vodafonetask.ui.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.techzone.vodafonetask.R;

public class SplashScreenActivity extends AppCompatActivity {

    private int SPLASH_TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView logoImage = findViewById(R.id.logo_image);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(SPLASH_TIME);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                        Intent intent=new Intent(SplashScreenActivity.this,AirlineActivity.class);
                        startActivity(intent);
                }
            }
        };
        timer.start();
        Animation myanim2 = AnimationUtils.loadAnimation(this,  R.anim.crossfade);
        logoImage.startAnimation(myanim2);
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}