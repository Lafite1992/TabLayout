package com.wzw.tablayout.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.wzw.tablayout.R;

/**
 * 通用的顶部Tab
 * Created by Henry on 2017/3/21.
 */

public class TopTabLayout extends CommonTabLayout {
    public TopTabLayout(Context context) {
        this(context,null);
    }

    public TopTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TopTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected View createTab(Tab tab) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.top_tab,null);
        ((TextView)view.findViewById(R.id.tv_top_title)).setText(tab.getLabelResId());
        return view;
    }
}
