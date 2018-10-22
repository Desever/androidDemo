package com.example.desever.desbb.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout  ;
import android.widget.TextView;
import com.example.desever.desbb.R;

public class DesTittleBarView extends LinearLayout  {

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
        //加载自定义布局
        LayoutInflater.from(context).inflate(R.layout.des_tittlebar_item,this,true);
        //初始化控件属性
        attributes = context.obtainStyledAttributes(attrs, R.styleable.DesTittleBarView);
        //设置标题
        this.setCenterTittleText();
        //设置左边按钮
        setLeftButtonText();
        //设置右边按钮
        setRightButtonText();
    }

    //得到所有属性
    //value
    private TypedArray attributes;

    //定义中间文字
    private TextView centerTittleText;

    //定义左边按钮图片父级
    private LinearLayout leftButtonParent;
    //定义左边按钮文字
    private TextView leftButton;
    //定义左边按钮图片
    private ImageView leftImg;


    //定义右边按钮图片父级
    private LinearLayout rightButtonParent;
    //定义右边按钮文字
    private TextView rightButton;
    //定义右边按钮图片
    private ImageView rightImg;


    //构建中间文字
    private void setCenterTittleText(){
        centerTittleText=findViewById(R.id.title_bar_title);
        //如果不是图片标题 则获取文字标题
        String titleText = attributes.getString(R.styleable.DesTittleBarView_center_tittle_text);
        //如果没有标题则不显示
        if(!TextUtils.isEmpty(titleText)){
            centerTittleText.setText(titleText);
        }

    }

    //构建左边按钮
    private void setLeftButtonText(){
        //判断是否渲染左边按钮
        boolean leftButtonVisible = attributes.getBoolean(R.styleable.DesTittleBarView_left_button_visible, true);
        //左边按钮父级
        leftButtonParent=findViewById(R.id.title_left_parent);
        //左边按钮
        leftButton=findViewById(R.id.title_bar_left);
        //左边按钮图片
        leftImg=findViewById(R.id.left_button_img);
        if(leftButtonVisible){
            //如果不是图片标题 则获取文字标题
            String leftButtonText = attributes.getString(R.styleable.DesTittleBarView_left_button_text);
            if(!TextUtils.isEmpty(leftButtonText)){
                leftButton.setText(leftButtonText);
            }
            //设置左边图片icon
            Drawable leftButtonDrawable = attributes.getDrawable(R.styleable.DesTittleBarView_left_button_drawable);
            if (leftButtonDrawable!=null) {
                leftImg.setImageDrawable(leftButtonDrawable);
            }
        }else{
            leftButtonParent.setVisibility(View.VISIBLE);
        }
    }


    //构建右边按钮
    private void setRightButtonText(){
        //判断是否渲染左边按钮
        boolean rightButtonVisible = attributes.getBoolean(R.styleable.DesTittleBarView_right_button_visible, true);
        //左边按钮父级
        rightButtonParent=findViewById(R.id.title_right_parent);
        //左边按钮
        leftButton=findViewById(R.id.title_bar_right);
        //左边按钮图片
        leftImg=findViewById(R.id.right_button_img);

        if(rightButtonVisible){
            //如果不是图片标题 则获取文字标题
            String rightButtonText = attributes.getString(R.styleable.DesTittleBarView_right_button_text);
            if(!TextUtils.isEmpty(rightButtonText)){
                leftButton.setText(rightButtonText);
            }
            //设置左边图片icon
            Drawable rightButtonDrawable = attributes.getDrawable(R.styleable.DesTittleBarView_right_button_drawable);
            if (rightButtonDrawable!=null) {
                leftImg.setImageDrawable(rightButtonDrawable);
            }
        }else{
            rightButtonParent.setVisibility(View.VISIBLE);
        }

    }






}
