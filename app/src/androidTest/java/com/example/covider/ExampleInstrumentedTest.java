package com.example.covider;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule<Profile> activityScenarioRule = new ActivityScenarioRule<>(Profile.class);

    @Test
    public void checkProfile(){

        onView(withId(R.id.name_first)).check(matches(withText("test")));
        onView(withId(R.id.name_last)).check(matches(withText("11")));
        onView(withId(R.id.email_profile)).check(matches(withText("alexanxo@usc.edu")));
        onView(withId(R.id.covid_profile)).check(matches(withText("false")));
        onView(withId(R.id.isInstructor)).check(matches(withText("false")));
    }
}