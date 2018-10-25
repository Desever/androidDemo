package com.example.desever.desbb.UI;
import android.content.Intent;
import android.os.Bundle;
import com.example.desever.desbb.R;
import com.example.desever.desbb.libs.DesActivity;

public class Splash extends DesActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Intent it=new Intent(getApplicationContext(),BootstrapActivity.class);//启动MainActivity

        Thread myThread=new Thread(){//创建子线程
            @Override
            public void run() {
                try{
                    sleep(1000);//使程序休眠五秒
                    startActivity(it);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();//启动线程

    }

}
