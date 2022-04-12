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
public class BuildingUITest {
    @Rule
    public ActivityScenarioRule<BuildingActivity> activityScenarioRule = new ActivityScenarioRule<>(BuildingActivity.class);

    @Test
    public void checkValues(){
        onView(withId(R.id.name_profile)).check(matches(withText("")));
        onView(withId(R.id.phone_profile)).check(matches(withText("")));
        onView(withId(R.id.country_profile)).check(matches(withText("")));
        onView(withId(R.id.entryreq)).check(matches(withText("Students and Faculty Must be in compliance with USC's Trojan Check Policies, for more information, check https://coronavirus.usc.edu/trojan-check-wellness-assessment-and-campus-access/")));
    }


}