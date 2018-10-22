package com.example.desever.desbb.component;
import android.content.Context;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/10/22.
 */
public class GlideImageLoader extends PagerAdapter {

    private Context mContext;
    private List<String> mData;

    public GlideImageLoader(Context context , List<String> list) {
        mContext = context;
        mData = list;
    }

}
