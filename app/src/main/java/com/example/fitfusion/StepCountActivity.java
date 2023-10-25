package com.example.fitfusion;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StepCountActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private boolean isRunning = false;
    private TextView txt_step_count;
    private FloatingActionButton step_start_btn;
    private float steps = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_count_activity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.step_counter);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#444d5a"));
        actionBar.setBackgroundDrawable(colorDrawable);
        if(Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.status_bar_color));
        }

        // Initialising the sensor manager to count the steps.
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        txt_step_count = findViewById(R.id.txt_step_count);
        step_start_btn = findViewById(R.id.step_start_btn);

        txt_step_count.setText(String.valueOf(steps));

        step_start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRunning) {
                    isRunning = false;
                    step_start_btn.setImageResource(R.drawable.ic_play);
                    displayToast("Counter Stopped..");
                } else {
                    isRunning = true;
                    step_start_btn.setImageResource(R.drawable.ic_pause);
                    displayToast("Counter Started..");
                    startCounting();
                }
            }
        });
    }

    private void startCounting() {
        isRunning = true;
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        if(sensor != null) {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            displayToast("Sensor not found.");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(isRunning) {
            steps = steps + sensorEvent.values[0];
            txt_step_count.setText(String.valueOf(steps));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}