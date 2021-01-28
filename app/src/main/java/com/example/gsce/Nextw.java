package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Nextw extends AppCompatActivity {

    ImageButton ibtnBack,ibtnObject, ibtnAnchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextw);

        ibtnBack = (ImageButton) findViewById(R.id.ibtnBack);
        ibtnAnchor = (ImageButton) findViewById(R.id.ibtnAnchor);
        ibtnObject = (ImageButton) findViewById(R.id.ibtnObject);

        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibtnAnchor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Nextw.this,Practice.class);
                startActivity(intent);
            }
        });

        ibtnObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Nextw.this, TopicActivity.class);
                startActivity(intent);
            }
        });
    }
}
