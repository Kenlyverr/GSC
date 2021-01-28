package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Newword extends AppCompatActivity {
    private LinearLayoutManager llm;
    private NewWordAdapter newWordAdapter;
    RecyclerView recyclerView;
    List<String> listText;
    ImageView btnBack;
    ImageButton ibtnAdd;
    EditText edit_word;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newword);
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        llm = new LinearLayoutManager(this);
        listText = new ArrayList<>();
        listText.add("hello");
        listText.add("Money");
        listText.add("welcome");
        listText.add("honey");
        listText.add("goodbye");
        listText.add("helicopter");
        listText.add("you");
        listText.add("car");
        listText.add("love");
        listText.add("water");
        listText.add("tree");
        listText.add("word");
        newWordAdapter = new NewWordAdapter(listText);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(newWordAdapter);

        edit_word= findViewById(R.id.edit_word);
        ibtnAdd= findViewById(R.id.ibtnAdd);
        btnDelete=findViewById(R.id.btnDelete);
        btnBack = findViewById(R.id.back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), HomeActivity.class);
                startActivity(intent);
            }
        });

        ibtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listText.add(edit_word.getText().toString());
                newWordAdapter.notifyDataSetChanged();

            }
        });
        recyclerView.setAdapter(newWordAdapter);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newWordAdapter.clearData();
                newWordAdapter.notifyDataSetChanged();
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