package com.example.desever.desbb.UI;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.example.desever.desbb.R;
import com.example.desever.desbb.libs.DesActivity;

public class BootstrapActivity extends DesActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bootstrap);

        //设置导航padding
        LinearLayout homeNav=findViewById(R.id.home_nav);
        setImmerseLayout(homeNav);
    }

    private void setHomeBanner(){

    }


}

