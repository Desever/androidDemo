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

        Map<String,Object> map = new HashMap<String,Object>();
        //key对应的from数组
        map.put("siple_tv1", "按钮");
        map.put("siple_tv2", "可以点击的东西");
        map.put("value", "button");
        list.add(map) ;



        return list;
    }


}
