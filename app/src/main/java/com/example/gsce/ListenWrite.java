package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ListenWrite extends AppCompatActivity {
    private ImageView mVolumn;
    private Button mNext;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_write);
        mVolumn = findViewById(R.id.volumn);
        mNext = findViewById(R.id.next);
        textView = findViewById(R.id.text);
        editText = findViewById(R.id.edit_text);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Hello");
                textView.setBackground(null);
            }
        });
    }
}