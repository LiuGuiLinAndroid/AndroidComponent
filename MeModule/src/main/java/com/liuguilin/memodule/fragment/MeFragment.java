package com.liuguilin.memodule.fragment;

import android.widget.TextView;

import com.liuguilin.basemodule.base.BaseFragment;
import com.liuguilin.memodule.R;
import com.liuguilin.memodule.R2;

import butterknife.BindView;

/**
 * FileName: MeFragment
 * Founder: LiuGuiLin
 * Create Date: 2019/11/4 15:48
 * Email: lgl@szokl.com.cn
 * Profile: 我的页面
 */
public class MeFragment extends BaseFragment {


    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.tv_me_1)
    TextView tvMe1;
    @BindView(R2.id.tv_me_2)
    TextView tvMe2;
    @BindView(R2.id.tv_me_3)
    TextView tvMe3;
    @BindView(R2.id.tv_me_4)
    TextView tvMe4;
    @BindView(R2.id.tv_me_5)
    TextView tvMe5;
    @BindView(R2.id.tv_me_6)
    TextView tvMe6;

    @Override
    protected int createView() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        tvTitle.setText("刘某人");
        tvMe1.setText("支付");
        tvMe2.setText("收藏");
        tvMe3.setText("相册");
        tvMe4.setText("卡包");
        tvMe5.setText("表情");
        tvMe6.setText("设置");
    }

    @Override
    protected void initListener() {

    }
}
