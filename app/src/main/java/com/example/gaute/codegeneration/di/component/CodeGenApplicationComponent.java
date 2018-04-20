package com.example.gaute.codegeneration.di.component;

import com.example.gaute.codegeneration.CodeGenApplication;
import com.example.gaute.codegeneration.di.module.ApplicationBindingModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by gaute on 3/25/18.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ApplicationBindingModule.class})
public interface CodeGenApplicationComponent extends AndroidInjector<CodeGenApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<CodeGenApplication> {
    }
}