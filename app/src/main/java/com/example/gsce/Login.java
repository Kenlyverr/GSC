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

public class Login extends AppCompatActivity {
    Button btnLogin;
    Button btnForgetPass;
    Button btnRegister;
    EditText edtEmail, edtPass;

    String Email,Pass;
    String urlLogin="http://192.168.1.8:8080/gsce/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getView();
        intentActivity();
    }
    private void getView(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.login);
        btnForgetPass = (Button) findViewById(R.id.quenmatkhau);
        btnRegister = (Button) findViewById(R.id.register);
    }
    private void intentActivity(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Email=edtEmail.getText().toString().trim();
//                Pass=getmd5ofstring(edtPass.getText().toString().trim());
                Pass=edtPass.getText().toString().trim();

                String emailFormat = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if(!Email.trim().matches(emailFormat)){
                    edtEmail.requestFocus();
                    edtEmail.setError("'Email' không hợp lệ");
                }
                else if(Email.length()==0)
                {
                    edtEmail.requestFocus();
                    edtEmail.setError("Chưa nhập 'Email'");
                }
                else if(Pass.length()==0)
                {
                    edtPass.requestFocus();
                    edtPass.setError("Chưa nhập 'Mật khẩu'");
                }
                else {
                    loginAcc(urlLogin);
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
        btnForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, ForgetPassword.class);
                startActivity(intent);
            }
        });
    }

    private void loginAcc(String url){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.trim().equals("success")){
                    Toast.makeText(Login.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, HomeActivity.class));
                }else{
                    Toast.makeText(Login.this,"Đăng nhập thất bại",Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this,"Error",Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("email",Email);
                params.put("pass",Pass);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}