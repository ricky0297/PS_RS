package com.example.ps_rs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view ){

        switch (view.getId()){
            case R.id.present: Intent intent = new Intent(MainActivity.this, presentacion.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                break;
            case R.id.acel: Intent intent1 = new Intent(MainActivity.this, acel.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);

                break;
            case R.id.pres: Intent intent2 = new Intent(MainActivity.this, Presion.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);

                break;
            case R.id.info: Intent intent3 = new Intent(MainActivity.this, info.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent3);

                break;
            case R.id.salir:
                finish();
               System.exit(0);

                break;

        }

    }
}