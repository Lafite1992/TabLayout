package com.wzw.tablayout.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wzw.tablayout.R;

/**
 *
 * Created by Henry on 2017/3/24.
 */

public class ContactFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.bottom_tab_contact);
        textView.setTextColor(Color.GREEN);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        return textView;
    }
}
