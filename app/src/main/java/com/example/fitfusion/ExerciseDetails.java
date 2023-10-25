package com.example.fitfusion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class ExerciseDetails extends AppCompatActivity {

    private LottieAnimationView lottie_exercise_details;
    private TextView txt_calories_details, txt_time_details, txt_description_details;
    private String exeName, exeDescription, exeImg;
    private int exeCalories, exeTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        exeName = getIntent().getStringExtra("exerciseName");
        exeDescription = getIntent().getStringExtra("description");
        exeImg = getIntent().getStringExtra("imageUrl");
        exeCalories = getIntent().getIntExtra("calories", 0);
        exeTime = getIntent().getIntExtra("time", 0);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(exeName);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#444d5a"));
        actionBar.setBackgroundDrawable(colorDrawable);
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_color));
        }

        lottie_exercise_details = findViewById(R.id.lottie_exercise_details);
        txt_calories_details = findViewById(R.id.txt_calories_details);
        txt_time_details = findViewById(R.id.txt_time_details);
        txt_description_details = findViewById(R.id.txt_description_details);

        lottie_exercise_details.setAnimationFromUrl(exeImg);
        txt_calories_details.setText("Calories: " + exeCalories);
        txt_time_details.setText("Time: " + exeTime + " Min");
        txt_description_details.setText(exeDescription);

    }
}