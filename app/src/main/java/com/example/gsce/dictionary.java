package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class dictionary extends AppCompatActivity {
    private LinearLayoutManager llm;
    private DictionaryAdapter dictionaryAdapter;
    RecyclerView recyclerView;
    List<String> listText;
    SearchView searchView;
    ImageView btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        recyclerView = findViewById(R.id.recycleView);
        llm = new LinearLayoutManager(this);
        listText = new ArrayList<>();
        listText.add("hello");
        listText.add("Money");
        listText.add("welcome");
        listText.add("honey");
        listText.add("goodbye");

        dictionaryAdapter = new DictionaryAdapter(listText);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(dictionaryAdapter);
        dictionaryAdapter.setOnClickListener(new ItemClick(){

            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplication(), DictionaryDetail.class);
                startActivity(intent);
            }


        } );

        searchView = findViewById(R.id.search);
        searchView.setQueryHint("Nhập từ cần tìm");
        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplication(), HomeActivity.class);
        startActivity(intent);
    }
}