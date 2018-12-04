package com.adrnangcao.hotrohoctap.hotrohoctap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class ManHinhChaoActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhchao);
        imageView = findViewById(R.id.imgmhc);
        Animation animSlide = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide);
        imageView.startAnimation(animSlide);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ManHinhChaoActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }
    }

