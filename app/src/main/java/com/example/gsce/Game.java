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

public class Game extends AppCompatActivity {

    customGameAdapter adapter;
    ImageButton ibtnAnchor,ibtnBack, ibtnObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        List<customGame> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView2);
        gridView.setAdapter(new customGameAdapter(this,R.layout.custom_gridview2 ,image_details));

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
                Intent intent= new Intent(Game.this,Practice.class);
                startActivity(intent);
            }
        });

        ibtnObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Game.this, TopicActivity.class);
                startActivity(intent);
            }
        });



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent= new Intent(Game.this,FindImage.class);
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent= new Intent(Game.this,Listen.class);
                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent= new Intent(Game.this,Matchword.class);
                    startActivity(intent);
                }
                if(position==3)
                {
                    Intent intent= new Intent(Game.this,Sortword.class);
                    startActivity(intent);
                }
                if(position==4)
                {
                    Intent intent= new Intent(Game.this,ListenWrite.class);
                    startActivity(intent);
                }
                if(position==5)
                {
                    Intent intent= new Intent(Game.this,ListenChoose.class);
                    startActivity(intent);
                }
                if(position==6)
                {
                    Intent intent= new Intent(Game.this,Sortword.class);
                    startActivity(intent);
                }
            }
        });
    }


    private  List<customGame> getListData() {
        List<customGame> list = new ArrayList<customGame>();
        customGame findimage = new customGame(R.drawable.chooseimage,"Tìm hình ảnh");
        customGame practicelisten = new customGame(R.drawable.listening,"Luyện nghe");
        customGame matchword = new customGame(R.drawable.wordmatch1,"Khớp từ");
        customGame listenandwrite = new customGame(R.drawable.write,"Nghe và viết");
        customGame listenandchoose = new customGame(R.drawable.listenandchoose,"Nghe và chọn");
        customGame sort = new customGame(R.drawable.sort,"Sắp xếp từ");

        list.add(findimage);
        list.add(practicelisten);
        list.add(matchword);
        list.add(listenandwrite);
        list.add(listenandchoose);
        list.add(sort);

        return list;
    }
}