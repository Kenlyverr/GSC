package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FindImage extends AppCompatActivity {

    customFindImageAdapter adapter;
    TextToSpeech speak;
    ImageButton ibtnAnchor,ibtnBack, ibtnObject ;
    TextView  txtVocabulary,txtMean3, txtVocabu,txtPoint;
    public String aa,bb,cc,dd,aaa,bbb,ccc,ddd;
    int point=0;
    int click=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_image);

        aa="Ông nội";
        bb="Bố";
        cc="Mẹ";
        dd="Chị(em) gái";
        aaa="Grandfather" ;
        bbb="Father";
        ccc="Mother";
        ddd="Sister";

        List<customFindImage> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView3);
        gridView.setAdapter(new customFindImageAdapter(this,R.layout.custom_gridview3 ,image_details));


        ibtnBack = (ImageButton) findViewById(R.id.ibtnBack);
        ibtnAnchor = (ImageButton) findViewById(R.id.ibtnAnchor);
        ibtnObject = (ImageButton) findViewById(R.id.ibtnObject);

        txtVocabulary = (TextView) findViewById(R.id.txtVocalbulary3);
        txtVocabu = (TextView) findViewById(R.id.txtVocabu);
        txtMean3 = (TextView) findViewById(R.id.txtMean3);
        txtPoint = (TextView) findViewById(R.id.txtPoint);

        point = Integer.parseInt (txtPoint.getText().toString());

        final String vocabu =  txtVocabu.getText().toString();

        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibtnAnchor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(FindImage.this,Practice.class);
                startActivity(intent);
            }
        });

        ibtnObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(FindImage.this, TopicActivity.class);
                startActivity(intent);
            }
        });
        speak = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    speak.setLanguage(Locale.US);
                }
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    click++;
                    if(aaa.equals(vocabu)){
                        Toast.makeText(FindImage.this, "Chính xác", Toast.LENGTH_LONG).show();
                        point++;
                        if(click>=2){
                            point--;
                        }
                        txtPoint.setText(Integer.toString(point));
                        speak.speak(aaa, TextToSpeech.QUEUE_FLUSH, null);
                        Intent intent = new Intent(FindImage.this, FindNext.class);
                        startActivity(intent);
                    }
                    else {
                        click=0;
                        speak.speak(aaa, TextToSpeech.QUEUE_FLUSH, null);
                        Toast.makeText(FindImage.this, "Chưa chính xác", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==1)
                {
                    click++;
                    if(bbb.equals(vocabu)){
                        Toast.makeText(FindImage.this, "Chính xác", Toast.LENGTH_LONG).show();
                        point++;
                        if(click>=2){
                            point--;
                        }
                        txtPoint.setText(Integer.toString(point));
                        speak.speak(bbb, TextToSpeech.QUEUE_FLUSH, null);
                    }
                    else {
                        click=0;
                        speak.speak(bbb, TextToSpeech.QUEUE_FLUSH, null);
                        Toast.makeText(FindImage.this, "Chưa chính xác", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==2)
                {
                    click++;
                    if(ccc.equals(vocabu)){
                        Toast.makeText(FindImage.this, "Chính xác", Toast.LENGTH_LONG).show();
                        point++;
                        if(click>=2){
                            point--;
                        }
                        txtPoint.setText(Integer.toString(point));
                        speak.speak(ccc, TextToSpeech.QUEUE_FLUSH, null);
                    }
                    else {
                        click=0;
                        speak.speak(ccc, TextToSpeech.QUEUE_FLUSH, null);
                        Toast.makeText(FindImage.this, "Chưa chính xác", Toast.LENGTH_LONG).show();
                    }
                }
                if(position==3)
                {
                    click++;
                    if(ddd.equals(vocabu)){
                        Toast.makeText(FindImage.this, "Chính xác", Toast.LENGTH_LONG).show();
                        point++;
                        if(click>=2){
                            point--;
                        }
                        txtPoint.setText(Integer.toString(point));
                        speak.speak(ddd, TextToSpeech.QUEUE_FLUSH, null);
                    }
                    else {
                        click=0;
                        speak.speak(ddd, TextToSpeech.QUEUE_FLUSH, null);
                        Toast.makeText(FindImage.this, "Chưa chính xác", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    private  List<customFindImage> getListData() {
        List<customFindImage> list = new ArrayList<customFindImage>();
        customFindImage a = new customFindImage(R.drawable.grandfather,aa,aaa);
        customFindImage b = new customFindImage(R.drawable.father,bb,bbb);
        customFindImage c = new customFindImage(R.drawable.mother,cc,ccc);
        customFindImage d = new customFindImage(R.drawable.sister1,dd,ddd);

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        return list;
    }
}
