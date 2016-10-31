package com.wushange.baselib.injector.component;

import android.content.Context;

import com.wushange.baselib.app.BaseApplication;
import com.wushange.baselib.base.BaseActivity;
import com.wushange.baselib.components.okhttp.OkHttpHelper;
import com.wushange.baselib.components.retrofit.RequestHelper;
import com.wushange.baselib.injector.module.ApiModule;
import com.wushange.baselib.injector.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sll on 2016/3/8.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    Context getContext();

    //
//    AccountApi getAccountApi();
//
//    AliFileApi getAliFileApi();
//
    OkHttpHelper getOkHttpHelper();

    //
    RequestHelper getRequestHelper();
//
//    UserUtil getUserUtil();
//
//    UserStorage getUserStorage();

    void inject(BaseApplication mApplication);

    void inject(BaseActivity mBaseActivity);

}
