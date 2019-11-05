package com.liuguilin.basemodule.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.liuguilin.basemodule.BuildConfig;

/**
 * FileName: BaseApp
 * Founder: LiuGuiLin
 * Create Date: 2019/10/31 20:03
 * Email: lgl@szokl.com.cn
 * Profile: App
 */
public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
