package com.example.ps_rs;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


public class acelFragment extends Fragment {

    TextView txt_currentAccel, txt_prevAccel, txt_acceleration;
    ProgressBar porg_shakeMeter;


    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private double accelerationCurrentValue;
    private double accelerationPreviousValue;

    private SensorEventListener sensorEventListener = new SensorEventListener() {


        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            accelerationCurrentValue = ( x + y + z );
            double changeInAccelleration = Math.abs(accelerationCurrentValue - accelerationPreviousValue);
            accelerationPreviousValue = accelerationCurrentValue;

            txt_currentAccel.setText("actual = "+ (int)accelerationCurrentValue);
            txt_prevAccel.setText("anterior ="+ (int)accelerationPreviousValue);
            txt_acceleration.setText("cambio de aceleracion =" +(int)changeInAccelleration);

            porg_shakeMeter.setProgress((int)accelerationCurrentValue*(int)accelerationCurrentValue);
            if(changeInAccelleration>9)
            {
                txt_acceleration.setBackgroundColor(Color.RED);

            }else if(changeInAccelleration>4){
                txt_acceleration.setBackgroundColor(Color.parseColor("#fcad03"));

            }else if(changeInAccelleration>2){
                txt_acceleration.setBackgroundColor(Color.YELLOW);

            }else {
                txt_acceleration.setBackgroundColor(getResources().getColor(R.color.design_default_color_background));

            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_a_l, container, false);
        View v = inflater.inflate(R.layout.fragment_acel, container, false);

        txt_acceleration= v.findViewById(R.id.txt_accel);
        txt_currentAccel= v.findViewById(R.id.txt_currentAccel);
        txt_prevAccel = v.findViewById(R.id.txt_prevAccel);

        porg_shakeMeter = v.findViewById(R.id.porg_shakeMeter);
        return v;


    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        mSensorManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);


    }
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
    }
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
}