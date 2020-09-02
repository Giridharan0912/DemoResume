package com.example.demo_1resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView splashScreen;
    TextView appName;
    TextView deve;

    Animation side,bottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splashScreen=findViewById(R.id.ivSplashScreen);
        appName=findViewById(R.id.tvAppName);
        deve=findViewById(R.id.tvDeveloper);
        side= AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottom= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        splashScreen.setAnimation(side);
        deve.setAnimation(bottom);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(), ProfilesListActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }
}