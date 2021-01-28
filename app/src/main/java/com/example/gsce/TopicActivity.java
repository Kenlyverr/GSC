package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TopicActivity extends AppCompatActivity {

    ListView lvChose;
    List<chose> arrayChose = new ArrayList<>();
    choseAdapter adapter;
    ImageButton ibtnLug,ibtnAnchor,ibtnBack;
    String urlTopic ="http://192.168.1.8:8080/gsce/getdatatopic.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lvChose=(ListView) findViewById(R.id.listview);
        getDataTopic(urlTopic);
//        Anhxa();
        adapter= new choseAdapter(this,R.layout.custom_adapter,arrayChose);
        lvChose.setAdapter(adapter);

        ibtnBack = findViewById(R.id.ibtnBack);
        ibtnAnchor = findViewById(R.id.ibtnAnchor);

        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        lvChose.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent= new Intent(TopicActivity.this,Vocabulary.class);
                    startActivity(intent);
                }
            }
        });

        ibtnLug = (ImageButton) findViewById(R.id.ibtnLuggage);
        ibtnLug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TopicActivity.this,Game.class);
                startActivity(intent);
            }
        });

        ibtnAnchor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TopicActivity.this,Vocabulary.class);
                startActivity(intent);
            }
        });

    }
    private void Anhxa(){
        lvChose=(ListView) findViewById(R.id.listview);
        arrayChose= new ArrayList<>();
        arrayChose.add(new chose("THE FAMILY", "3",1));
        arrayChose.add(new chose("THE FAMILY", "4",1));
        arrayChose.add(new chose("THE FAMILY", "5",1));
        arrayChose.add(new chose("THE FAMILY", "6",1));
        arrayChose.add(new chose("THE FAMILY", "7",1));
        arrayChose.add(new chose("THE FAMILY", "8",1));
    }

    private void getDataTopic(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0; i< response.length();i++){
                    try {
                        JSONObject object = response.getJSONObject(i);
                        arrayChose.add(new chose(
                                object.getString("Name"),
                                object.getString("Point"),
                                (1)
                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TopicActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

}
