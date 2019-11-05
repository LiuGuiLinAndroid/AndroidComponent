package com.liuguilin.basemodule.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

/**
 * FileName: BaseFragment
 * Founder: LiuGuiLin
 * Create Date: 2019/11/4 15:20
 * Email: lgl@szokl.com.cn
 * Profile: Fragment 基类
 */
public abstract class BaseFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(createView(), null);
        ButterKnife.bind(this,mView);
        initView();
        initData();
        initListener();
        return mView;
    }
}
