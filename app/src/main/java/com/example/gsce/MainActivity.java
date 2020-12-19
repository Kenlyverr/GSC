package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvChose;
    ArrayList<chose> arrayChose;
    choseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();
        adapter= new choseAdapter(this,R.layout.custom_adapter,arrayChose);
        lvChose.setAdapter(adapter);

        lvChose.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {

                }
            }
        });

    }
    private void Anhxa(){
        lvChose=(ListView) findViewById(R.id.listview);
        arrayChose= new ArrayList<>();
        arrayChose.add(new chose("THE FAMILY", "3",1));
        arrayChose.add(new chose("THE FAMILY", "4",2));
        arrayChose.add(new chose("THE FAMILY", "5",3));
        arrayChose.add(new chose("THE FAMILY", "6",4));
        arrayChose.add(new chose("THE FAMILY", "7",5));
        arrayChose.add(new chose("THE FAMILY", "8",6));
    }
}
