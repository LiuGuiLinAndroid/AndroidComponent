package com.liuguilin.basemodule.helper;

import android.app.Activity;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * FileName: ARouterHelper
 * Founder: LiuGuiLin
 * Create Date: 2019/10/31 21:15
 * Email: lgl@szokl.com.cn
 * Profile: 路由帮助类
 */
public class ARouterHelper {

    private static volatile ARouterHelper mInstance = null;

    private ARouterHelper() {
    }

    public static ARouterHelper getInstance() {
        if (mInstance == null) {
            synchronized (ARouterHelper.class) {
                if (mInstance == null) {
                    mInstance = new ARouterHelper();
                }
            }
        }
        return mInstance;
    }

    //-------------------------ChatModule-------------------------
    public static final String PATH_CHAT_RUN = "/ChatModule/ChatRunActivity";

    //-------------------------ContactModule-------------------------
    public static final String PATH_CONTACT_RUN = "/ContactModule/ContactRunActivity";

    //-------------------------FindModule-------------------------
    public static final String PATH_FIND_RUN = "/FindModule/FindRunActivity";

    //-------------------------MeModule-------------------------
    public static final String PATH_ME_RUN = "/MeModule/MeRunActivity";

    /**
     * 直接跳转
     *
     * @param path
     */
    public void build(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    /**
     * 跳转有回调
     *
     * @param path
     * @param mActivity
     * @param requestCode
     */
    public void build(String path, Activity mActivity, int requestCode) {
        ARouter.getInstance().build(path).navigation(mActivity, requestCode);
    }

    /**
     * 跳转传递参数
     *
     * @param path
     * @param key
     * @param values
     */
    public void build(String path, String key, String values) {
        ARouter.getInstance().build(path)
                .withString(key, values)
                .navigation();
    }

    /**
     * 跳转传递参数
     *
     * @param path
     * @param bundle
     */
    public void build(String path, Bundle bundle) {
        ARouter.getInstance().build(path)
                .with(bundle)
                .navigation();
    }
}
