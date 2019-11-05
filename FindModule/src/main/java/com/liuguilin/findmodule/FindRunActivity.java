package com.liuguilin.findmodule;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.liuguilin.basemodule.base.BaseActivity;
import com.liuguilin.basemodule.helper.ARouterHelper;

/**
 * FileName: FindRunActivity
 * Founder: LiuGuiLin
 * Create Date: 2019/11/5 10:41
 * Email: lgl@szokl.com.cn
 * Profile:
 */
@Route(path = ARouterHelper.PATH_FIND_RUN)
public class FindRunActivity extends BaseActivity {

    @Override
    protected int createView() {
        return R.layout.activity_find_run;
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
