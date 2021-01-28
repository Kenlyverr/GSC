package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Locale;

public class Listen extends AppCompatActivity {

    ImageButton ibtnBack,ibtnObject, ibtnAnchor,ibtnSound4;
    TextToSpeech Speech;
    String listen;
    Button btnAns1,btnAns2,btnAns3,btnAns4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);

        ibtnBack = (ImageButton) findViewById(R.id.ibtnBack);
        ibtnAnchor = (ImageButton) findViewById(R.id.ibtnAnchor);
        ibtnObject = (ImageButton) findViewById(R.id.ibtnObject);
        ibtnSound4 = findViewById(R.id.ibtnSound4);
        btnAns1 = findViewById(R.id.btnAns1);
        btnAns2 = findViewById(R.id.btnAns2);
        btnAns3 = findViewById(R.id.btnAns3);
        btnAns4 = findViewById(R.id.btnAns4);



        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibtnAnchor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Listen.this,Practice.class);
                startActivity(intent);
            }
        });

        ibtnObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Listen.this, TopicActivity.class);
                startActivity(intent);
            }
        });
        ibtnSound4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listen = "Grandfather";
                Speech= new TextToSpeech(Listen.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status!= TextToSpeech.ERROR)
                        {
                            Speech.setLanguage(Locale.US);
                            Speech.speak(listen, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                });
            }
        });
        btnAns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Listen.this, "Chính xác",Toast.LENGTH_SHORT).show();
            }
        });
        btnAns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Listen.this, "chưa chính xác",Toast.LENGTH_SHORT).show();
            }
        });
        btnAns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Listen.this, "chưa chính xác",Toast.LENGTH_SHORT).show();
            }
        });
        btnAns4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Listen.this, "chưa chính xác",Toast.LENGTH_SHORT).show();
            }
        });






    }
}
