package com.wzw.tablayout.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.wzw.tablayout.R;

/**
 * 通用的底部Tab
 * Created by Henry on 2017/3/22.
 */

public class BottomTabLayout extends CommonTabLayout {
    public BottomTabLayout(Context context) {
        this(context,null);
    }

    public BottomTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BottomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected View createTab(Tab tab) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_tab,null);
        ((ImageView)view.findViewById(R.id.iv_bottom_icon)).setImageResource(tab.getImgResId());
        ((TextView)view.findViewById(R.id.tv_bottom_label)).setText(tab.getLabelResId());
        return view;
    }
}
