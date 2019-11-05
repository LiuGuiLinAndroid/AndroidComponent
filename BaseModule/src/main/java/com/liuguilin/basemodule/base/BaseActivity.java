package com.liuguilin.basemodule.base;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * FileName: BaseActivity
 * Founder: LiuGuiLin
 * Create Date: 2019/11/4 15:31
 * Email: lgl@szokl.com.cn
 * Profile: Activity 基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    //视图
    protected View mView;

    //创建View
    protected abstract int createView();

    //初始化View
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    //初始化监听
    protected abstract void initListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = View.inflate(this, createView(), null);
        setContentView(mView);
        ButterKnife.bind(this);
        getSupportActionBar().setElevation(0);
        initView();
        initData();
        initListener();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
