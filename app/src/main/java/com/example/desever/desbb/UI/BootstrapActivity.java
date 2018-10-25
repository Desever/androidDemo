package com.example.desever.desbb.UI;
import android.os.Bundle;
import android.view.View;
import com.example.desever.desbb.R;
import com.example.desever.desbb.component.DesTittleBarView;
import com.example.desever.desbb.fragment.HomeFragment;
import com.example.desever.desbb.libs.DesActivity;


public class BootstrapActivity extends DesActivity {

    //首页导航
    DesTittleBarView homeNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bootstrap);

        //设置导航padding
        homeNav=findViewById(R.id.home_nav);
        setImmerseLayout(homeNav);

        //添加布局
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_fragment_container,new HomeFragment())
                .commit();
        //初始化导航点击事件
        initNavButtonClick();

    }

    //导航点击事件
    private void initNavButtonClick(){
        homeNav.setLeftCustomCallBack(new DesTittleBarView.CustomCallBack() {
            @Override
            public void onclick(View v) {
                toastLong("左边按钮");
            }
        });
        homeNav.setRightCustomCallBack(new DesTittleBarView.CustomCallBack() {
            @Override
            public void onclick(View v) {
                toastLong("右边按钮");
            }
        });
    }

}

