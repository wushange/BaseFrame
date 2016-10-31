package com.wushange.baselib.injector.module;

import android.app.Activity;

import com.wushange.baselib.injector.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sll on 2016/1/6.
 */
@Module
public class ActivityModule {

  private final Activity mActivity;

  public ActivityModule(Activity mActivity) {
    this.mActivity = mActivity;
  }

  @Provides
  @PerActivity
  public Activity provideActivity() {
    return mActivity;
  }
}
