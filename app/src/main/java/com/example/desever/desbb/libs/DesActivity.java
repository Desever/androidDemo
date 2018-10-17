package com.example.desever.desbb.libs;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class DesActivity extends AppCompatActivity {

    private static Toast toast;


    //退出倒计时
    private long exitTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        //开启沉浸式
        this.setActionBarType();
    }

    //重写父类方法，点击空白区域关闭键盘
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (DesActivity.this.getCurrentFocus() != null) {
                if (DesActivity.this.getCurrentFocus().getWindowToken() != null) {
                    imm.hideSoftInputFromWindow(DesActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        }
        return super.onTouchEvent(event);
    }


    //判断当前是不是最后一个activity
    @Override
    //改写父类返回键
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            //exit();
            if (isTaskRoot()) {
                exit();
            }
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }
    //退出
    private void exit(){
        if((System.currentTimeMillis()-exitTime)>2000) {
            toastLong("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        }
        else{
            finish();
            System.exit(0);
        }
    }
    //设置沉浸式
    private void setActionBarType(){
        //getWindow().setStatusBarColor(Color.TRANSPARENT);// Color.TRANSPARENT = 0 表示#00000000即透明颜色
        //getWindow().setNavigationBarColor(Color.TRANSPARENT);
        getSupportActionBar().hide();//隐藏标题栏
    }
    /**
     * 显示长toast
     * @param msg
     */
    public void toastLong(String msg){
        if (null == toast) {
            toast = Toast.makeText(this,msg,Toast.LENGTH_LONG);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }
    /**
     * 显示短toast
     * @param msg
     */
    public void toastShort(String msg){
        if (null == toast) {
            toast = toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }
}
