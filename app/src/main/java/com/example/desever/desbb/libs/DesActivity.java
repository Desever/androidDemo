package com.example.desever.desbb.libs;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class DesActivity extends AppCompatActivity {

    /***封装toast对象**/
    private static Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);

        //开启沉浸式
        this.setActionBarType();
    }

    //设置沉浸式
    private void setActionBarType(){
        getSupportActionBar().hide();
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
    /**
     * 显示长toast
     * @param msg
     */
    public void toastLong(String msg){
        if (null == toast) {
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setText(msg);
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
            toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setText(msg);
            toast.show();
        } else {
            toast.setText(msg);
            toast.show();
        }
    }
}
