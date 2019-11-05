package com.liuguilin.chatmodule;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.liuguilin.basemodule.base.BaseActivity;
import com.liuguilin.basemodule.helper.ARouterHelper;

/**
 * FileName: ChatMainActivity
 * Founder: LiuGuiLin
 * Create Date: 2019/10/31 20:08
 * Email: lgl@szokl.com.cn
 * Profile: Chat 启动页
 */
@Route(path = ARouterHelper.PATH_CHAT_RUN)
public class ChatRunActivity extends BaseActivity {

    @Override
    protected int createView() {
        return R.layout.activity_chat_run;
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
