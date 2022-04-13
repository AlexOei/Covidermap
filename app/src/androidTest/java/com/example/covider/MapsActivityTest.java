package com.example.covider;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class MapsActivityTest {
    @Rule
    public ActivityScenarioRule<MapsActivity> activityScenarioRule = new ActivityScenarioRule<>(MapsActivity.class);
    @Test
    public void checkLocations(){
        onView(withId(R.id.locations)).perform(click());
        onView(withId(R.id.fab)).check(matches(isDisplayed()));
    }

    @Test
    public void checkProfile(){
        onView(withId(R.id.profile)).perform(click());
        onView(withId(R.id.name_first)).check(matches(isDisplayed()));
    }

    @Test
    public void checkHealthCheck(){
        onView(withId(R.id.healthCheck)).perform(click());
        onView(withId(R.id.covidPositve)).check(matches(isDisplayed()));
    }

    @Test
    public void checkCheckIn(){
        onView(withId(R.id.checkIn)).perform(click());
        onView(withId(R.id.Excellent)).check(matches(isDisplayed()));
    }

    @Test
    public void checkLogOut(){
        onView(withId(R.id.logOut)).perform(click());
        onView(withId(R.id.btn_llogin)).check(matches(isDisplayed()));
    }

    @Test
    public void checkSections(){
        onView(withId(R.id.section)).perform(click());
        onView(withId(R.id.firstSection)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMap(){
        onView(withId(R.id.map)).check(matches(isDisplayed()));
    }


}
