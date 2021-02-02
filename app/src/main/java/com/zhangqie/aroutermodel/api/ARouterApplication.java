package com.zhangqie.aroutermodel.api;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by zhangqie on 2018/9/12
 * Describe:
 */
public class ARouterApplication extends Application {

    private boolean isDebug = true;
    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebug) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init( this ); // 尽可能早，推荐在Application中初始化
    }

}
