package com.wushange.baselib.app;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.wushange.baselib.injector.component.ApplicationComponent;
import com.wushange.baselib.injector.component.DaggerApplicationComponent;
import com.wushange.baselib.injector.module.ApplicationModule;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * 这个application在实际项目中可以继承
 * Created by wushange on 2016/06/01.
 */
public class BaseApplication extends Application {
    private static BaseApplication INSTANCE;
    private ApplicationComponent mApplicationComponent;
    /**
     * 对外提供整个应用生命周期的Context
     **/
    private static Context context;
    @Inject
    OkHttpClient mOkHttpClient;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        context = this;
        Logger.init("WUSHANGE").logLevel(LogLevel.FULL);
    }


    private void initComponent() {
        mApplicationComponent =
                DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static BaseApplication getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new BaseApplication();
        }
        return INSTANCE;
    }


    /**
     * 对外提供Application Context
     *
     * @return
     */
    public static Context getContext() {
        return context;
    }


}
