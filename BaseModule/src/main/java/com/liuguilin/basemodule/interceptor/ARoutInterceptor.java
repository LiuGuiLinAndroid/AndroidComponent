package com.liuguilin.basemodule.interceptor;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * FileName: ARoutInterceptor
 * Founder: LiuGuiLin
 * Profile: ARouter 拦截器
 */
@Interceptor(priority = 8, name = "ARoutInterceptor")
public class ARoutInterceptor implements IInterceptor {

    private String TAG = "ARoutInterceptor";

    public void init(Context context) {

    }

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.i(TAG, postcard.getPath());
        //判断条件
        boolean isOpen = true;
        if (isOpen) {
            //不拦截
            callback.onContinue(postcard);
        } else {
            //拦截
            callback.onInterrupt(new Throwable("No Open"));
        }
    }


}
