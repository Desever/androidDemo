package com.example.desever.desbb.UI;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.desever.desbb.DataClass.HomeData;
import com.example.desever.desbb.R;
import com.example.desever.desbb.libs.DesActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BootstrapActivity extends DesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bootstrap);

        //初始化首页数据
        this.initHome();
    }

    //首页数据类
    private HomeData myHomeClass;

    //退出倒计时
    private long exitTime=0;

    @Override
    //改写父类返回键
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            exit();
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }
    //退出
    private void exit(){
        if((System.currentTimeMillis()-exitTime)>2000) {
            Toast.makeText(getApplicationContext(),
                    "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        }
        else{
            finish();
            System.exit(0);
        }
    }

    //初始化首页
    private void initHome(){
        //获取首页数据
        this.myHomeClass=new HomeData();
        List<Map<String, Object>> list=this.myHomeClass.returnListHomeData();

        //获取listview
        ListView bb_list = (ListView) findViewById(R.id.bb_list);
        String[] from = {"siple_tv1", "siple_tv2" };
        int[] to = { R.id.siple_tv1,R.id.siple_tv2} ;
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list,R.layout.home_list_item, from, to);
        bb_list.setAdapter(simpleAdapter) ;

        //绑定点击事件
        bb_list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listClickFunc(parent,view,position,id);
            }
        });

    }
    //点击事件回调
    private void listClickFunc(AdapterView<?> parent, View view, int position, long id){
        //获取value值
        ListView listView = (ListView)parent;
        HashMap<String, String> map = (HashMap<String, String>) listView.getItemAtPosition(position);
        String value = map.get("value");
    }
}
