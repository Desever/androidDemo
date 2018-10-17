package com.example.desever.desbb.UI;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.desever.desbb.R;
import com.example.desever.desbb.libs.DesActivity;

public class LoginActivity extends DesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //添加登录按钮监听
        this.actionLogin();
    }

    //点击登录按钮
    private void actionLogin(){
        //登录按钮点击
        Button loginBtn=findViewById(R.id.login_button);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=getPhone();
                String password=getPass();
                toastLong("电话:"+phone+"密码:"+password);
            }
        });
    }

    //获取手机号
    private String getPhone(){
        String phone="";
        EditText phoneEidt=findViewById(R.id.login_phone);
        phone=phoneEidt.getText().toString();
        return phone;
    }

    //获取密码
    private String getPass(){
        String password="";
        EditText phoneEidt=findViewById(R.id.login_password);
        password=phoneEidt.getText().toString();
        return password;
    }



}
