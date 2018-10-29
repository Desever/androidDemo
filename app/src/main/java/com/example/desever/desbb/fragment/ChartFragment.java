package com.example.desever.desbb.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.desever.desbb.R;

public class ChartFragment extends Fragment {
    //获取当前fragmen容器
    View fragmenParent;
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        fragmenParent = inflater.inflate(R.layout.chart_fragment, container, false);
        return fragmenParent;
    }
}
