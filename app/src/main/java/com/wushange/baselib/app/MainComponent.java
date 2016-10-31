package com.wushange.baselib.app;


import com.wushange.baselib.injector.PerActivity;
import com.wushange.baselib.injector.component.ApplicationComponent;
import com.wushange.baselib.injector.module.ActivityModule;

import dagger.Component;

/**
 * Created by sll on 2016/5/13.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {
        ActivityModule.class
})
public interface MainComponent {

//    void inject(MainActivity activity);

}
