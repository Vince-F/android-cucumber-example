package com.example.myapplication.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

public class CatScreenRobot {
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
