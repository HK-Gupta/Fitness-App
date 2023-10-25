package com.example.fitfusion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity implements ExerciseAdapter.ExerciseClickInterface {

    private RecyclerView exercise_recycler_view;
    private ArrayList<ExerciseModel> exerciseModelArrayList;
    private ExerciseAdapter exerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.exercise_bar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#444d5a"));
        actionBar.setBackgroundDrawable(colorDrawable);
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_color));
        }

        exercise_recycler_view = findViewById(R.id.exercise_recycler_view);
        exerciseModelArrayList = new ArrayList<>();
        exerciseAdapter = new ExerciseAdapter(exerciseModelArrayList, this, this::onExerciseClick);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        exercise_recycler_view.setLayoutManager(linearLayoutManager);
        exercise_recycler_view.setAdapter(exerciseAdapter);
        addData();

    }

    private void addData() {
        exerciseModelArrayList.add(new ExerciseModel("Jumping Jacks", getResources().getString(R.string.jumping_jack), "https://lottie.host/daf6b9f3-0eb7-4e06-8ecd-dfc8d89d10a9/miCVYJ22f8.json", 150, 10));
        exerciseModelArrayList.add(new ExerciseModel("Body-weight Squats", getResources().getString(R.string.bodyweight_squats), "https://lottie.host/fea78459-94bf-4803-aae2-36423a6b4ad4/wjn9JnMfy8.json", 100, 10));
        exerciseModelArrayList.add(new ExerciseModel("Push-Ups", getResources().getString(R.string.push_ups), "https://lottie.host/6b689f97-32b3-4855-a920-e2cba58584fb/CYjcKDXvX8.json", 100, 15));
        exerciseModelArrayList.add(new ExerciseModel("Planks", getResources().getString(R.string.planks), "https://lottie.host/bd2ebbc6-658a-4804-a6e5-8408e1790ad6/4UuuSMioeH.json", 40, 10));
        exerciseModelArrayList.add(new ExerciseModel("Lunges", getResources().getString(R.string.lunges), "https://lottie.host/ce87615d-a202-49ea-a9de-8aeea1b0adb7/ePcPLAL34x.json", 120, 15));
        exerciseModelArrayList.add(new ExerciseModel("Burpees", getResources().getString(R.string.burpees), "https://lottie.host/c13963ba-8aa7-4832-93b8-d29104c1d7d1/jwqXGl2VQf.json", 200, 15));
        exerciseModelArrayList.add(new ExerciseModel("Mountain Climbers", getResources().getString(R.string.crunches), "https://lottie.host/d0a0080f-b732-4c19-b3b1-7678a61c0ea0/E7Z4sKdAe3.json", 30, 10));
        exerciseAdapter.notifyDataSetChanged();
    }
    @Override
    public void onExerciseClick(int position) {
        Intent intent = new Intent(ExerciseActivity.this, ExerciseDetails.class);
        intent.putExtra("exerciseName", exerciseModelArrayList.get(position).getExerciseName());
        intent.putExtra("imageUrl", exerciseModelArrayList.get(position).getExerciseIMGUrl());
        intent.putExtra("time", exerciseModelArrayList.get(position).getTime());
        intent.putExtra("calories", exerciseModelArrayList.get(position).getCaloriesCount());
        intent.putExtra("description", exerciseModelArrayList.get(position).getExerciseDescription());
        startActivity(intent);
    }
}