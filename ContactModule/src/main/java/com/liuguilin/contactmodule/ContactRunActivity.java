package com.liuguilin.contactmodule;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.liuguilin.basemodule.base.BaseActivity;
import com.liuguilin.basemodule.helper.ARouterHelper;

/**
 * FileName: ContactRunActivity
 * Founder: LiuGuiLin
 * Create Date: 2019/11/5 11:04
 * Email: lgl@szokl.com.cn
 * Profile: 联系人
 */

@Route(path = ARouterHelper.PATH_CONTACT_RUN)
public class ContactRunActivity extends BaseActivity {

    @Override
    protected int createView() {
        return R.layout.activity_contact_run;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
