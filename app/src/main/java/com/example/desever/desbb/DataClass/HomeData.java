package com.example.desever.desbb.DataClass;

import com.example.desever.desbb.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeData {


    private void HomeData(){

    }
    //返回list渲染lisstviw
    public List<Map<String, Object>> returnListHomeData(){
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>() ;
        for(int i=0;i<13;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("tittle_text", "尊敬的用户");
            map.put("content_text", "尊敬的用户您好，我们将于2017年11月3日进行系统全面升级，感谢您的支持与配合，我们将作出以尊敬的用户");
            map.put("footer_text", "来自金融网");
            map.put("ico_src",R.mipmap.logo);
            list.add(map);
        }
        return list;
    }


}
