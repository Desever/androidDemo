package com.example.desever.desbb.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.desever.desbb.R;

public class DesTittleBarView extends LinearLayout{

    public DesTittleBarView(Context context) {
        this(context, null, 0);
    }
    public DesTittleBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        //初始化控件
        this.bootstartpView(context);
    }
    public DesTittleBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //初始化所有布局
    private void bootstartpView(Context context){
        //加载自定义布局
        LayoutInflater.from(context).inflate(R.layout.des_tittlebar_item,null,false);
        //初始化控件属性
        //attributes = context.obtainStyledAttributes(attrs, R.styleable.DesTittleBarView);
        //设置标题
        //this.setCenterTittleText();
    }

    //得到所有属性
    private TypedArray attributes;


    //定义布局父级
    private LinearLayout titleParent;

    //定义中间文字
    private TextView centerTittleText;


    //构建中间文字
    private void setCenterTittleText(){
        centerTittleText=findViewById(R.id.title_bar_title);
        //如果不是图片标题 则获取文字标题
        String titleText = attributes.getString(R.styleable.DesTittleBarView_center_tittle_text);
        centerTittleText.setText(titleText);
    }


}
