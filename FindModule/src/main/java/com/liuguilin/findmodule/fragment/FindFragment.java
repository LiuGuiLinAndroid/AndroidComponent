package com.liuguilin.findmodule.fragment;

import android.widget.TextView;

import com.liuguilin.basemodule.base.BaseFragment;
import com.liuguilin.findmodule.R;
import com.liuguilin.findmodule.R2;

import butterknife.BindView;

/**
 * FileName: FindFragment
 * Founder: LiuGuiLin
 * Create Date: 2019/11/5 13:20
 * Email: lgl@szokl.com.cn
 * Profile: 发现
 */
public class FindFragment extends BaseFragment {

    @BindView(R2.id.tv_find_1)
    TextView tvFind1;
    @BindView(R2.id.tv_find_2)
    TextView tvFind2;
    @BindView(R2.id.tv_find_3)
    TextView tvFind3;
    @BindView(R2.id.tv_find_4)
    TextView tvFind4;

    @Override
    protected int createView() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        tvFind1.setText("朋友圈");
        tvFind2.setText("扫一扫");
        tvFind3.setText("游戏");
        tvFind4.setText("小程序");
    }

    @Override
    protected void initListener() {

    }
}
