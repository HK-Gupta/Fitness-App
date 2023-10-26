package com.example.fitfusion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    ImageView image_start;
    TextView text_app_name, text_dev_name;
    Animation top_animation, bottom_animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.bar_name);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#222738"));
        actionBar.setBackgroundDrawable(colorDrawable);
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_color));
        }

        image_start = findViewById(R.id.image_start);
        text_app_name = findViewById(R.id.text_app_name);
        text_dev_name = findViewById(R.id.text_dev_name);

        top_animation = AnimationUtils.loadAnimation(this, R.anim.top);
        bottom_animation = AnimationUtils.loadAnimation(this, R.anim.bottom);
        image_start.setAnimation(top_animation);
        text_app_name.setAnimation(bottom_animation);
        text_dev_name.setAnimation(bottom_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
            }
        }, 4000);
    }
}