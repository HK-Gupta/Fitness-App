package com.example.fitfusion;

public class ExerciseModel {
    private String exerciseName, exerciseDescription, exerciseIMGUrl;
    private int caloriesCount, time;

    public ExerciseModel(String exerciseName, String exerciseDescription, String exerciseIMGUrl, int caloriesCount, int time) {
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.exerciseIMGUrl = exerciseIMGUrl;
        this.caloriesCount = caloriesCount;
        this.time = time;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public String getExerciseIMGUrl() {
        return exerciseIMGUrl;
    }

    public void setExerciseIMGUrl(String exerciseIMGUrl) {
        this.exerciseIMGUrl = exerciseIMGUrl;
    }

    public int getCaloriesCount() {
        return caloriesCount;
    }

    public void setCaloriesCount(int caloriesCount) {
        this.caloriesCount = caloriesCount;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
