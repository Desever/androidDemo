package com.example.desever.desbb.UI;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.desever.desbb.R;
import com.example.desever.desbb.component.DesTittleBarView;
import com.example.desever.desbb.fragment.ChartFragment;
import com.example.desever.desbb.fragment.HomeFragment;
import com.example.desever.desbb.fragment.HotFragment;
import com.example.desever.desbb.libs.DesActivity;

public class BootstrapActivity extends DesActivity {


    //首页父级、图片、文字
    private LinearLayout homeButtonPar;
    private ImageView homeButtonImg;
    private TextView homeButtonText;

    //报告父级、图片、文字
    private LinearLayout reportButtonPar;
    private ImageView reportButtonImg;
    private TextView reportButtonText;

    //统计父级、图片、文字
    private LinearLayout charttButtonPar;
    private ImageView chartButtonImg;
    private TextView chartButtonText;

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
        //初始化fragment页面
        changeFragmentPage("home");
        //初始化底部点击事件
        initBottomNavClick();
    }

    //页面初始化工作
    private void initView(){

        //赋值按钮元素
        //首页
        homeButtonPar=findViewById(R.id.bottom_home);
        homeButtonImg=findViewById(R.id.bottom_home_img);
        //首页默认选中
        homeButtonImg.setActivated(true);

        //报告
        reportButtonPar=findViewById(R.id.bottom_report);
        reportButtonImg=findViewById(R.id.bottom_report_img);
        //统计
        charttButtonPar=findViewById(R.id.bottom_chart);
        chartButtonImg=findViewById(R.id.bottom_chart_img);

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


    //初始化页面切换点击事件
    private void initBottomNavClick(){
        homeButtonPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //切换样式
                changeBottomButtonStyle(v);
                //切换页面
                changeFragmentPage("home");
            }
        });
        reportButtonPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //切换样式
                changeBottomButtonStyle(v);
                //切换页面
                changeFragmentPage("hot");
            }
        });
        charttButtonPar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //切换样式
                changeBottomButtonStyle(v);
                //切换页面
                changeFragmentPage("chart");
            }
        });
    }
    //设置底部tab样式
    private void changeBottomButtonStyle(View v){
        //还原所有样式
        homeButtonImg.setActivated(false);
        reportButtonImg.setActivated(false);
        chartButtonImg.setActivated(false);
        //选中当前点击项
        switch (v.getId()){
            case R.id.bottom_home:
                homeButtonImg.setActivated(true);
                break;
            case R.id.bottom_report:
                reportButtonImg.setActivated(true);
                break;
            case R.id.bottom_chart:
                chartButtonImg.setActivated(true);
                break;
        }
    }
    //初始化Fragment页面
    //切换Fragment
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

