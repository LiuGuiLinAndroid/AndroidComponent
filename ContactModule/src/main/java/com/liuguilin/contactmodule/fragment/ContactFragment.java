package com.liuguilin.contactmodule.fragment;

import android.widget.TextView;

import com.liuguilin.basemodule.base.BaseFragment;
import com.liuguilin.contactmodule.R;
import com.liuguilin.contactmodule.R2;

import butterknife.BindView;

/**
 * FileName: ContactFragment
 * Founder: LiuGuiLin
 * Create Date: 2019/11/5 12:31
 * Email: lgl@szokl.com.cn
 * Profile: 联系人
 */
public class ContactFragment extends BaseFragment {

    @BindView(R2.id.tv_contact_1)
    TextView tvContact1;
    @BindView(R2.id.tv_contact_2)
    TextView tvContact2;
    @BindView(R2.id.tv_contact_3)
    TextView tvContact3;
    @BindView(R2.id.tv_contact_4)
    TextView tvContact4;

    @Override
    protected int createView() {
        return R.layout.fragment_contact;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        tvContact1.setText("新朋友");
        tvContact2.setText("群聊");
        tvContact3.setText("标签");
        tvContact4.setText("公众号");
    }

    @Override
    protected void initListener() {

    }
}
