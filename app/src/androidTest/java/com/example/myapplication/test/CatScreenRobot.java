package com.example.myapplication.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class CatScreenRobot {

    private static final String ACTIVITY_TO_BE_TESTED = "com.example.myapplication.MainActivity";

    public void setupWithInstalledApk() {
        Class activityClass = null;
        try {
            activityClass = Class.forName(ACTIVITY_TO_BE_TESTED);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        instrumentation.setInTouchMode(true);

        final String targetPackage = instrumentation.getTargetContext().getPackageName();
        Intent startIntent = new Intent(Intent.ACTION_MAIN);
        startIntent.setClassName(targetPackage, activityClass.getName());
        startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        instrumentation.startActivitySync(startIntent);
        instrumentation.waitForIdleSync();
    }

    public void launchCatActivity() {
        ActivityScenario.launch(MainActivity.class);
    }

    public void clickWhoIsButton() {
        onView(withId(R.id.button_first)).perform(click());
    }

    public void checkBestCatText() {
        onView(withId(R.id.textview_second)).check(matches(withText("It's Porto!")));
    }

    public void checkBestCatTextFailing() {
        onView(withId(R.id.textview_second)).check(matches(withText("It's Porto! And he is not eating too much")));
    }
}
