package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accept1 extends AppCompatActivity {
    private Button btnChophep;
    private Button btnTuchoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept1);
        btnChophep = (Button) findViewById(R.id.chophep);
        btnTuchoi = (Button) findViewById(R.id.tuchoi);
        btnTuchoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Accept1.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        btnChophep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Accept1.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}