package com.assignmentss.safehouse;

import android.app.Application;

import timber.log.Timber;

public class MyApp extends Application {

    public MyApp() {
        Timber.plant(new Timber.DebugTree());
    }
}
