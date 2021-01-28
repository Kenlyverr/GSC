package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Practice extends AppCompatActivity {

    ImageButton ibtnBack, ibtnObject, ibtnLug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        ibtnBack = (ImageButton) findViewById(R.id.ibtnBack);
        ibtnObject = (ImageButton) findViewById(R.id.ibtnObject);
        ibtnLug = (ImageButton) findViewById(R.id.ibtnLuggage);

        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibtnLug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Practice.this,Game.class);
                startActivity(intent);
            }
        });

        ibtnObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Practice.this, TopicActivity.class);
                startActivity(intent);
            }
        });
    }
}
