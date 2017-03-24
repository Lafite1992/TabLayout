package com.wzw.tablayout.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

/**
 * 通用的TabLayout,子类可以继承它并实现createTab()创建特有的TabLayout
 * Created by Henry on 2017/3/21.
 */

public abstract class CommonTabLayout extends LinearLayout {
    private OnTabClickListener mOnTabClickListener;
    private List<Tab> mTabs;
    public CommonTabLayout(Context context) {
        this(context,null);
    }

    public CommonTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CommonTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
    }

    public void setTab(List<Tab> tabs){
        if(tabs == null || tabs.size() == 0){
            return;
        }
        this.mTabs = tabs;
        init();
        //默认选中第一个Tab
        setTabSelected(0);
    }

    private void init() {
        View view;
        int size = mTabs.size();
        LayoutParams params = new LayoutParams(0,LayoutParams.WRAP_CONTENT);
        params.weight = 1;
        for (int i = 0; i < size; i++) {
            view = createTab(mTabs.get(i));
            setOnClick(view,i);
            addView(view,params);
        }
    }

    private void setOnClick(final View view, final int position) {
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabSelected(position);
                if(mOnTabClickListener != null){
                    mOnTabClickListener.onTabClick(view,position);
                }
            }
        });
    }

    /**
     * 由子类创建特有的TabView
     * @param tab
     * @return
     */
    protected abstract View createTab(Tab tab);

    public void setTabSelected(int index) {
        setTabSelected(mTabs.get(index));
    }

    private void setTabSelected(Tab tab) {
        int size = mTabs.size();
        for (int i = 0; i < size; i++) {
            setTabSelectedStyle(getChildAt(i),mTabs.get(i) == tab);
        }
    }

    /**
     * 设置Tab被选中时的样式，子类可以重写该方法实现特有的样式
     * @param view
     * @param isSelected
     */
    protected void setTabSelectedStyle(View view, boolean isSelected){
        view.setSelected(isSelected);
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.mOnTabClickListener = onTabClickListener;
    }
    /**
     * 将事件回调给外层的接口
     */
    public interface OnTabClickListener{

        /**
         * 当Tab被点击时回调
         * @param view
         * @param position
         */
        void onTabClick(View view, int position);
    }
    public static class Tab{
        private int imgResId;
        private int labelResId;

        public Tab() {
        }

        public Tab(int labelResId) {
            this.labelResId = labelResId;
        }

        public Tab(int imgResId, int labelResId) {
            this.imgResId = imgResId;
            this.labelResId = labelResId;
        }

        public int getImgResId() {
            return imgResId;
        }

        public void setImgResId(int imgResId) {
            this.imgResId = imgResId;
        }

        public int getLabelResId() {
            return labelResId;
        }

        public void setLabelResId(int labelResId) {
            this.labelResId = labelResId;
        }
    }
}
