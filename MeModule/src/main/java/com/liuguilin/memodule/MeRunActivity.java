package com.liuguilin.memodule;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.liuguilin.basemodule.base.BaseActivity;
import com.liuguilin.basemodule.helper.ARouterHelper;

/**
 * FileName: MeMainActivity
 * Founder: LiuGuiLin
 * Create Date: 2019/10/31 20:14
 * Email: lgl@szokl.com.cn
 * Profile: Me 启动页
 */
@Route(path = ARouterHelper.PATH_ME_RUN)
public class MeRunActivity extends BaseActivity {

    @Override
    protected int createView() {
        return R.layout.activity_me_run;
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
