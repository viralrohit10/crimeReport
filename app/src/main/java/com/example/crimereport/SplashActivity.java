package com.example.crimereport;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    ImageView imageView;
    private static int SPLASH_SCREEN_TIME_OUT=3000;
    ProgressBar progressBar;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        imageView=findViewById(R.id.imageView);

        progressBar=findViewById(R.id.pbar);

        progressBar.setVisibility(View.VISIBLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i=new Intent(SplashActivity.this,
                            MainActivity.class);
                    progressBar.setVisibility(View.INVISIBLE);
                    startActivity(i);
                    finish();

                }
            }, SPLASH_SCREEN_TIME_OUT);
        }
    }