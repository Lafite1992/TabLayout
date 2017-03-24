package com.wzw.tablayout.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wzw.tablayout.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_top_tab).setOnClickListener(this);
        findViewById(R.id.btn_bottom_tab).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_top_tab:
                startActivity(new Intent(this,TopTabActivity.class));
                break;
            case R.id.btn_bottom_tab:
                startActivity(new Intent(this,BottomTabActivity.class));
                break;
        }
    }
}
