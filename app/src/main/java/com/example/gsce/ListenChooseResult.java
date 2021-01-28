package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListenChooseResult extends AppCompatActivity {
    private ImageView btnListen;
    private TextView txtView;
    private Button btnResult1;
    private Button btnResult2;
    private Button btnTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_choose_result);
        btnListen = findViewById(R.id.btnlisten);
        btnResult1 = findViewById(R.id.button1);
        btnResult2 = findViewById(R.id.button2);
        btnTest = findViewById(R.id.test);
        txtView = findViewById(R.id.textView12);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnResult1.setText("mass\n" +
                        "/mæs/");
                btnResult2.setText("math\n" +
                        "/mæθ/");
                txtView.setText("Chú ý sự khác biệt");
                btnListen.setVisibility(View.INVISIBLE);
                btnTest.setText("Tiếp theo");
            }
        });
    }
}