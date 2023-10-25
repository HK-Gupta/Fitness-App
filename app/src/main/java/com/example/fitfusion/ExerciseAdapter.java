package com.example.fitfusion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {

    private ArrayList<ExerciseModel> exerciseModelArrayList;
    private Context context;
    private ExerciseClickInterface exerciseClickInterface;

    public ExerciseAdapter(ArrayList<ExerciseModel> exerciseModelArrayList, Context context, ExerciseClickInterface exerciseClickInterface) {
        this.exerciseModelArrayList = exerciseModelArrayList;
        this.context = context;
        this.exerciseClickInterface = exerciseClickInterface;
    }

    @NonNull
    @Override
    public ExerciseAdapter.ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_rv_layout, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseAdapter.ExerciseViewHolder holder, int position) {
        holder.rv_exercise_name.setText(exerciseModelArrayList.get(position).getExerciseName());
        holder.lottie_rv_exercise.setAnimationFromUrl(exerciseModelArrayList.get(position).getExerciseIMGUrl());
        String time = String.valueOf(exerciseModelArrayList.get(position).getTime());
        holder.rv_exercise_time.setText(time + " Minutes");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exerciseClickInterface.onExerciseClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseModelArrayList.size();
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder{
        private LottieAnimationView lottie_rv_exercise;
        private TextView rv_exercise_name, rv_exercise_time;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            lottie_rv_exercise = itemView.findViewById(R.id.lottie_rv_exercise);
            rv_exercise_name = itemView.findViewById(R.id.rv_exercise_name);
            rv_exercise_time = itemView.findViewById(R.id.rv_exercise_time);
        }
    }

    public interface ExerciseClickInterface {
        void onExerciseClick(int position);
    }
}
