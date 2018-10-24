package com.example.desever.desbb.component;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;
/**
 * Created by Administrator on 2018/10/22.
 *
 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(context).load((Integer) path).into(imageView);
    }
}
