package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class Vocabulary extends AppCompatActivity {

    ImageButton imgbtn, imgAnchor, ibtnLug;
    String urlTopic ="https://eyapplycation.000webhostapp.com/getdatatopic.php";
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        List<custom> image_details = getListData();
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new customAdapter(this,R.layout.custom_gridview ,image_details));

        imgbtn = (ImageButton) findViewById(R.id.ibtnBack);
        imgAnchor = (ImageButton) findViewById(R.id.ibtnAnchor);
        ibtnLug = (ImageButton) findViewById(R.id.ibtnLuggage);

        imgAnchor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Vocabulary.this,Practice.class);
                startActivity(intent);
            }
        });

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibtnLug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Vocabulary.this,Game.class);
                startActivity(intent);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {

                }
            }
        });
    }


//    private List<custom> getDataTopic(String url){
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        List<custom> list = new ArrayList<custom>();
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                for (int i=0; i< response.length();i++){
//                    try {
//                        JSONObject object = response.getJSONObject(i);
//                        list.add(new custom(
//                                object.getString("UrlImage"),
//                                object.getString("Pronounce"),
//                                object.getString("VVoca"),
//                                object.getString("EVoca")
//                        ));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(Vocabulary.this,error.toString(),Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//        requestQueue.add(jsonArrayRequest);
//        Toast.makeText(Vocabulary.this,""+list,Toast.LENGTH_SHORT).show();
//        return list;
//
//
//    }




    private  List<custom> getListData() {
        List<custom> list = new ArrayList<custom>();
        custom grandfather = new custom(R.drawable.grandfather, "ˈɡran(d)ˌfäT͟Hər","Grandfather","Ông nội");
        custom grandmother = new custom(R.drawable.grandmother, "ˈɡran(d)ˌməT͟Hər","Grandmother","Bà ngoại");
        custom father = new custom(R.drawable.father, "ˈfäT͟Hər","Father","Bố");
        custom mother = new custom(R.drawable.mother, "ˈməT͟Hər","Mother","Mẹ");

        list.add(grandfather);
        list.add(grandmother);
        list.add(father);
        list.add(mother);


        return list;

    }
}
