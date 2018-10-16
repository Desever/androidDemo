package com.example.desever.desbb.component.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.desever.desbb.R;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        //基础按钮点击事件
        this.myListener();

        //按钮文字修改
        this.changeBtnText();

        //美化按钮
        this.styleButtonOneClist();

    }

    //android button点击事件一
    //定义构造方法
    //基础按钮
    private void myListener() {
        Button bt=findViewById(R.id.btn_click_one);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "定义构造方法按钮", Toast.LENGTH_LONG).show();
            }
        });
    }

    //点击按钮修改文字
    private void changeBtnText(){
        final Button changeText=findViewById(R.id.change_btn_text);
        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText.setText("我的内容被修改了");
            }
        });

    }

    //美化按钮一
    private void styleButtonOneClist(){
        Button styleOneButton=findViewById(R.id.style_one_button);
        styleOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ButtonActivity.this, "我是美化的按钮", Toast.LENGTH_LONG).show();
            }
        });
    }










}
