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
import android.widget.TextView;


public class presionFragment extends Fragment {
    private TextView textView;
    private SensorManager sensorManager;
    private Sensor pressureSensor;
    private Boolean isPressureSensorAvailable;
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            textView.setText(sensorEvent.values[0]+ " hPa");
            if((sensorEvent.values[0]>700))
            {
                textView.setBackgroundColor(Color.RED);

            }else if((sensorEvent.values[0]>400)){
                textView.setBackgroundColor(Color.parseColor("#fcad03"));

            }else if((sensorEvent.values[0]>200)){
                textView.setBackgroundColor(Color.YELLOW);

            }else {
                textView.setBackgroundColor(getResources().getColor(R.color.design_default_color_background));

            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }



    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_presion, container, false);
        textView = v.findViewById(R.id.tv2);
        return v;


    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)!=null){
            pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
            isPressureSensorAvailable = true;

        }else {
            textView.setText("el sensor de presion esta activo");
            isPressureSensorAvailable = false;
        }


    }


    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(sensorEventListener, pressureSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

}