package com.example.desever.desbb.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.desever.desbb.R;

public class DesTittleBarView extends LinearLayout{


    public DesTittleBarView(Context context) {
        super(context);
    }
    public DesTittleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //绘制导航
        this.bootstartpView(context,attrs);
    }
    public DesTittleBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //初始化所有布局
    private void bootstartpView(Context context,AttributeSet attrs){
        //获取父级
        LinearLayout titleParent =findViewById(R.id.des_tittlebar_view);
        //加载自定义布局
        LayoutInflater.from(context).inflate(R.layout.des_tittlebar_item,titleParent,true);
        //初始化控件属性
        attributes = context.obtainStyledAttributes(attrs, R.styleable.DesTittleBarView);
        //设置标题
        this.setCenterTittleText();
    }

    //得到所有属性
    //value
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
