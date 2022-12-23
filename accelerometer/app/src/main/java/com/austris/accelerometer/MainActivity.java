package com.austris.accelerometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private SensorManager sm;
    private Sensor sensor;
    TextView text1;

    // listener supplied into registerListener
    SensorEventListener eventListener = new SensorEventListener(){
        public void onAccuracyChanged(Sensor sensor, int accuracy) {}
        public void onSensorChanged(SensorEvent event) {
            float[] values = event.values;
            text1.setText("x = "+values[0]+"\n y = "+values[1]+"\nz = "+values[2]);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting test field by ID
        text1 = (TextView)findViewById(R.id.text1);

        // initializing accelerometer
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // sensor listener (can adjust sensitivity SensorManager.SENSOR_DELAY_NORMAL)
        sm.registerListener(eventListener, sensor , SensorManager.SENSOR_DELAY_NORMAL);
    }
}