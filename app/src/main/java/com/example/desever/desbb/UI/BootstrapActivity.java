package com.example.desever.desbb.UI;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.desever.desbb.R;
import com.example.desever.desbb.component.DesTittleBarView;
import com.example.desever.desbb.fragment.ChartFragment;
import com.example.desever.desbb.fragment.HomeFragment;
import com.example.desever.desbb.fragment.HotFragment;
import com.example.desever.desbb.libs.DesActivity;


public class BootstrapActivity extends DesActivity {

    //首页导航
    DesTittleBarView homeNav;

    //侧边栏
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bootstrap);

        //页面初始化
        initView();

        //初始化顶部导航点击事件
        initNavButtonClick();
        //初始化底部导航点击
        initBottomNavClick();
        //初始化fragment页面
        changeFragmentPage("home");
    }


    //页面初始化工作
    private void initView(){
        //设置导航padding
        homeNav=findViewById(R.id.home_nav);
        setImmerseLayout(homeNav);
        //获取侧边栏
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
    }


    //导航点击事件
    private void initNavButtonClick(){
        homeNav.setLeftCustomCallBack(new DesTittleBarView.CustomCallBack() {
            @Override
            public void onclick(View v) {
                showDrawerLayout();
            }
        });
        homeNav.setRightCustomCallBack(new DesTittleBarView.CustomCallBack() {
            @Override
            public void onclick(View v) {
                toastLong("右边按钮");
            }
        });
    }


    //监听底部导航点击事件
    private void initBottomNavClick(){
//        RadioGroup bottomNav = (RadioGroup) findViewById(R.id.main_navi_radiogroup);
//        bottomNav.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.bottom_nav_home:
//                        changeFragmentPage("home");
//                        break;
//                    case R.id.bottom_nav_hot:
//                        changeFragmentPage("hot");
//                        break;
//                    case R.id.bottom_nav_our:
//                        changeFragmentPage("user");
//                        break;
//                }
//            }
//        });
    }


    //初始化Fragment页面
    private void changeFragmentPage(String pageName){
        //导航标题组件
        TextView centerText=homeNav.findViewById(R.id.title_bar_title);
        if(pageName=="home"){
            //添加布局
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment_container,new HomeFragment())
                    .commit();

            //修改标题文字
            centerText.setText("首页");

        }else if(pageName=="hot"){
            //添加布局
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment_container,new HotFragment())
                    .commit();

            //修改标题文字
            centerText.setText("报告");
        }else{
            //添加布局
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_fragment_container,new ChartFragment())
                    .commit();
            //修改标题文字
            centerText.setText("统计");
        }

    }

    //关闭和打开侧边栏
    private void showDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.openDrawer(Gravity.LEFT);
        } else {
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }



}

