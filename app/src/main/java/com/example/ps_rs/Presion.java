package com.example.ps_rs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Presion extends AppCompatActivity {

    presionFragment fragmentAL = new presionFragment();
    PinfoFragment  fragmentP  = new PinfoFragment();
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presion);


    }
    public void onClick(View view ){
        transaction=getSupportFragmentManager() .beginTransaction();
        switch (view.getId()){
            case R.id.p1:transaction.replace(R.id.contendorFrame,fragmentAL);
                transaction.addToBackStack(null);

                break;
            case R.id.p2:transaction.replace(R.id.contendorFrame,fragmentP);
                transaction.addToBackStack(null);
                break;
            case R.id.r2 :Intent intent = new Intent(Presion.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

            break;


        }
        transaction.commit();
    }
}