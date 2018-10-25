package com.example.desever.desbb.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.desever.desbb.DataClass.HomeData;
import com.example.desever.desbb.R;
import com.example.desever.desbb.component.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeFragment extends Fragment {

    //首页数据对象
    HomeData homeData=new HomeData();


    //获取当前fragmen容器
    View fragmenParent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmenParent = inflater.inflate(R.layout.home_fragment, container, false);

        initBanner();
        setHomeList();


        return fragmenParent;
    }


    //设置banner
    private void initBanner(){
        Banner banner = fragmenParent.findViewById(R.id.banner);
        //初始化控件高度
        DisplayMetrics dm = getResources().getDisplayMetrics();
        banner.getLayoutParams().height=dm.widthPixels/2;
        //设置图片资源:url或本地资源
        List<Integer> images= new ArrayList<>();
        images.add(R.mipmap.banner);
        images.add(R.mipmap.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置banner样式
        //显示数字
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }


    //设置列表
    private void setHomeList(){
        ListView homeList=fragmenParent.findViewById(R.id.home_list_view);
        List<Map<String, Object>> homeListData=homeData.returnListHomeData();
        SimpleAdapter adapter = new SimpleAdapter(
                this.getActivity(),homeListData,
                R.layout.home_list_item,
                new String[] { "tittle_text", "content_text", "footer_text","ico_src"},
                new int[] {R.id.tittle_text,R.id.content_text,R.id.footer_text,R.id.ico_src}
        );
        homeList.setAdapter(adapter);
    }






}
