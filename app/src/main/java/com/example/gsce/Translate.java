package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Translate extends AppCompatActivity {
    private LinearLayoutManager llm;
    private RecyclerHistoryAdapter listHistoryTranslateAdapter;
    RecyclerView recyclerView;
    List<String> listText;
    List<String> listMean;
    ImageView btnBack;
    Button btn_translate1,btn_translate2;
    TextView mean_translate;
    EditText textArea_information;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        recyclerView = findViewById(R.id.recycler);
        llm = new LinearLayoutManager(this);
        listText = new ArrayList<>();
        listMean = new ArrayList<>();
        listText.add("hello");
        listText.add("Money");
        listText.add("welcome");
        listText.add("honey");
        listText.add("goodbye");
        listMean.add("Xin chào");
        listMean.add("Tiền");
        listMean.add("Xin chào");
        listMean.add("mật ong");
        listMean.add("Tạm biệt");
        listHistoryTranslateAdapter = new RecyclerHistoryAdapter(listText, this, listMean);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(listHistoryTranslateAdapter);
        btnBack = findViewById(R.id.back);
        btn_translate2=findViewById(R.id.btn_translate2);
        mean_translate = findViewById(R.id.mean_translate);
        textArea_information= findViewById(R.id.textArea_information);
        btn_translate1 = findViewById(R.id.btn_translate1);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Translate.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        textArea_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mean_translate.setText("");
            }
        });

        btn_translate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textArea_information.getText().toString().equalsIgnoreCase("Hello")){
                mean_translate.setText("Xin chào");
                }
                else if(textArea_information.getText().toString().equalsIgnoreCase("Good")){
                    mean_translate.setText("Tốt");
                }
                else Toast.makeText(Translate.this, "Không nhận ra từ của bạn", Toast.LENGTH_SHORT).show();
            }
        });

        btn_translate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textArea_information.getText().toString().equalsIgnoreCase("Tiền")){
                mean_translate.setText("Money");
                }
                else if(textArea_information.getText().toString().equalsIgnoreCase("Pháp sư")) {
                    mean_translate.setText("Mage");
                }
                else Toast.makeText(Translate.this, "Không nhận ra từ của bạn", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Translate.this, HomeActivity.class);
        startActivity(intent);
    }
}