package com.example.gaute.codegeneration;

import com.example.gaute.codegeneration.di.component.DaggerCodeGenApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by gaute on 3/25/18.
 */
public class CodeGenApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {

        return DaggerCodeGenApplicationComponent
                .builder()
                .create(this);
    }
}
