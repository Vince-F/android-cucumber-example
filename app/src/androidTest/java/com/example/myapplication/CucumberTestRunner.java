package com.example.myapplication;

import android.os.Bundle;

import androidx.test.runner.AndroidJUnitRunner;

import cucumber.api.android.CucumberInstrumentationCore;

public class CucumberTestRunner extends AndroidJUnitRunner {
    private static final String CUCUMBER_TAGS_KEY = "tags";
    private static final String CUCUMBER_SCENARIO_KEY = "name";
    private final CucumberInstrumentationCore instrumentationCore = new CucumberInstrumentationCore(this);
    @Override
    public void onCreate(final Bundle bundle) {
        instrumentationCore.create(bundle);
        super.onCreate(bundle);
    }
    @Override
    public void onStart() {
        waitForIdleSync();
        instrumentationCore.start();
    }
}
