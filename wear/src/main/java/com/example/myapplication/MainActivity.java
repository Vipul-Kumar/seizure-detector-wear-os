package com.example.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

public class MainActivity extends WearableActivity implements SensorEventListener {

    private TextView accelerometerX, accelerometerY, accelerometerZ;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accelerometerX = findViewById(R.id.accelerometer_x);
        accelerometerY = findViewById(R.id.accelerometer_y);
        accelerometerZ = findViewById(R.id.accelerometer_z);

        // Enables Always-on
        setAmbientEnabled();
    }

    @Override
    public void onResume() {
        super.onResume();
        registerAccelerometer();
    }

    @Override
    public void onPause() {
        super.onPause();
        unregisterAccelerometer();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        int sensorX  = (int)sensorEvent.values[0];
        int sensorY  = (int)sensorEvent.values[1];
        int sensorZ  = (int)sensorEvent.values[2];

        accelerometerX.setText("X : " + String.valueOf(sensorX));
        accelerometerY.setText("Y : " + String.valueOf(sensorY));
        accelerometerZ.setText("Z : " + String.valueOf(sensorZ));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    private void registerAccelerometer() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    private void unregisterAccelerometer() {
        sensorManager.unregisterListener(this);
    }
}
