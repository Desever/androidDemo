package com.example.desever.desbb.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.desever.desbb.R;

public class BottombarView extends LinearLayout implements View.OnClickListener{


    //首页父级、图片、文字
    private LinearLayout homeButtonPar;
    private ImageView homeButtonImg;
    private TextView homeButtonText;

    //报告父级、图片、文字
    private LinearLayout reportButtonPar;
    private ImageView reportButtonImg;
    private TextView reportButtonText;

    //统计父级、图片、文字
    private LinearLayout charttButtonPar;
    private ImageView chartButtonImg;
    private TextView chartButtonText;


    public BottombarView(Context context) {
        super(context);
    }
    public BottombarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化布局
        bootstartpView(context);
    }
    public BottombarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //初始化所有布局
    private void bootstartpView(Context context){
        //加载自定义布局
        LayoutInflater.from(context).inflate(R.layout.des_bottombar_item,this,true);
    }


    //初始化点击事件
    @Override
    public void onClick(View v){

    }



}
