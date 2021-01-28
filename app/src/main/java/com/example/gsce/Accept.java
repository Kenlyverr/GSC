package com.example.gsce;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;

public class Accept extends AppCompatActivity {
    private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept);
        countTime();
    }
    private void countTime(){
        countDownTimer = new CountDownTimer(3500, 250) {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTick(long l) {

            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(Accept.this, Accept1.class);
                startActivity(intent);
            }
        };
        countDownTimer.start();
    }
}