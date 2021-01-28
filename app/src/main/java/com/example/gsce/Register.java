package com.example.gsce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    private Button btnLogin;
    private Button btnRegister;
    EditText edtEmail,edtPass;
    String emailFormat = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String Email, Pass;
    String urlInsert="http://192.168.1.8:8080/gsce/insert1.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnLogin = (Button) findViewById(R.id.login);
        edtEmail = findViewById(R.id.edt_email);
        edtPass =findViewById(R.id.edt_pass);
        btnRegister = (Button) findViewById(R.id.register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email=edtEmail.getText().toString();
                Pass=edtPass.getText().toString();
                if(!Email.trim().matches(emailFormat)){
                    edtEmail.requestFocus();
                    edtEmail.setError("'Email' không hợp lệ");
                }
                else if(Email.length()==0)
                {
                    edtEmail.requestFocus();
                    edtEmail.setError("'Email' không được để trống");
                }
                else if(Pass.length()==0)
                {
                    edtPass.requestFocus();
                    edtPass.setError("'Mật khẩu' không được để trống");
                }
                else if(Pass.length()<6 )
                {
                    edtPass.requestFocus();
                    edtPass.setError("'Mật khẩu' phải có ít nhất 6 kí tự");
                }
                else {
                    RegisterAccount(urlInsert);

                }
            }
        });

    }
    private void RegisterAccount(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.trim().equals("success")){
                            Toast.makeText(Register.this,"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Register.this,"Error",Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Register.this,"Lỗi server",Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("email",Email);
                params.put("pass",Pass);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}