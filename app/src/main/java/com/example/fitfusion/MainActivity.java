package com.example.fitfusion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LinearLayout exercise_LL, stepCount_LL;
    LottieAnimationView lottie_exercise, lottie_stepCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        // initialising the id's.
        exercise_LL = findViewById(R.id.exercise_LL);
        stepCount_LL = findViewById(R.id.stepCount_LL);
        lottie_exercise = findViewById(R.id.lottie_exercise);
        lottie_stepCount = findViewById(R.id.lottie_stepCount);

        // Setting the animation for the LAV's.
        lottie_exercise.setAnimationFromUrl("https://lottie.host/d8c9915f-07c0-4ac0-9205-d92124de7e41/6ROIU0W65h.json");
        lottie_stepCount.setAnimationFromUrl("https://lottie.host/a2c0e5c5-c169-4cc2-93bd-0c2ad997a48c/sGbixHNFZt.json");

        exercise_LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callNextActivity(ExerciseActivity.class);
            }
        });

        stepCount_LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callNextActivity(StepCountActivity.class);
            }
        });
    }

    private void callNextActivity(Class<?> nextClass) {
        Intent intent = new Intent(MainActivity.this, nextClass);
        startActivity(intent);
    }


}