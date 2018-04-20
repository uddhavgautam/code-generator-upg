package com.example.gaute.codegeneration;

import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    CodeGenApplication codeGenApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                CreateAllEntities createAllEntities = new CreateAllEntities();
//            }
//        }).start();

    }
}
