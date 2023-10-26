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
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#222738"));
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
        exerciseModelArrayList.add(new ExerciseModel("Jumping Jacks", getResources().getString(R.string.jumping_jack), "https://lottie.host/387ed72c-9a6b-4bc2-add9-9e98c2c9e6c3/ao20wJLdhb.json", 150, 10));
        exerciseModelArrayList.add(new ExerciseModel("Body-weight Squats", getResources().getString(R.string.bodyweight_squats), "https://lottie.host/d832b893-baf6-48fc-8e77-49bfd46517a6/L9wSgAPhiH.json", 100, 10));
        exerciseModelArrayList.add(new ExerciseModel("Push-Ups", getResources().getString(R.string.push_ups), "https://lottie.host/76d4447f-5946-4005-b0bf-8baef5610050/zU42E4eoqy.json", 100, 15));
        exerciseModelArrayList.add(new ExerciseModel("Planks", getResources().getString(R.string.planks), "https://lottie.host/bd2ebbc6-658a-4804-a6e5-8408e1790ad6/4UuuSMioeH.json", 40, 10));
        exerciseModelArrayList.add(new ExerciseModel("Lunges", getResources().getString(R.string.lunges), "https://lottie.host/7b71d114-2ce4-4b84-9c84-dbe88652c0e3/n2swG2UMu5.json", 120, 15));
        exerciseModelArrayList.add(new ExerciseModel("Burpees", getResources().getString(R.string.burpees), "https://lottie.host/ef18f827-638e-4646-84b5-923c9b0ffdc9/wGuzEeupLT.json", 200, 15));
        exerciseModelArrayList.add(new ExerciseModel("Crunches", getResources().getString(R.string.crunches), "https://lottie.host/d0a0080f-b732-4c19-b3b1-7678a61c0ea0/E7Z4sKdAe3.json", 30, 10));
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