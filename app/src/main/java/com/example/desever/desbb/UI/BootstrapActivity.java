package com.example.desever.desbb.UI;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.example.desever.desbb.R;
import com.example.desever.desbb.component.GlideImageLoader;
import com.example.desever.desbb.libs.DesActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class BootstrapActivity extends DesActivity {

    private Banner banner;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bootstrap);

        //设置导航padding
        LinearLayout homeNav=findViewById(R.id.home_nav);
        setImmerseLayout(homeNav);

        initBanner();

    }


    private void initBanner(){

        //设置图片资源:url或本地资源
        List<String> images= new ArrayList<>();
        images.add("http://zcimg.zcool.com.cn/zcimg/m_c6fe5449f86a0000016004e746c6.jpg");

        //设置图片标题:自动对应
        List<String> titles=new ArrayList<>();
        titles.add("十大星级品牌联盟，全场2折起");

        Banner banner = (Banner) findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }



}

