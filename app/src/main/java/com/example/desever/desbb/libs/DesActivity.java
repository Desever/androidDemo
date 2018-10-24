package com.example.desever.desbb.libs;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class DesActivity extends AppCompatActivity {

    private static Toast toast;


    //退出倒计时
    private long exitTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //沉浸式
        this.setActionBarType();
        super.onCreate( savedInstanceState);
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



    @Override
    //判断当前是不是最后一个activity
    //改写父类返回键
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            //exit();
            if (isTaskRoot()) {
                exit();
            }else{
                finish();
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


    //返回状态栏高度
    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    //设置沉浸式
    public void setActionBarType(){
        //沉浸式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }
    //如果开启沉浸式，修改元素padding
    protected void setImmerseLayout(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int statusBarHeight = getStatusBarHeight(this.getBaseContext());
            //重绘导航高度
             view.setPadding(0, statusBarHeight, 0, 0);
        }
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
