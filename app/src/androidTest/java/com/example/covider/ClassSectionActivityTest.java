package com.example.covider;


import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.click;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ClassSectionActivityTest {
    @Rule
    public ActivityScenarioRule<ClassSectionActivity> activityScenarioRule = new ActivityScenarioRule<>(ClassSectionActivity.class);
    @Test
    public void checkCodes(){
        onView(withId(R.id.code4)).perform(typeText("Engineer"));
        onView(withId(R.id.code4)).check(matches(withText("Engineer")));
        onView(withId(R.id.code1)).perform(typeText("Engineer"));
        onView(withId(R.id.code1)).check(matches(withText("Engineer")));
        onView(withId(R.id.code2)).perform(typeText("Engineer"));
        onView(withId(R.id.code2)).check(matches(withText("Engineer")));
        onView(withId(R.id.code3)).perform(typeText("Engineer"));
        onView(withId(R.id.code3)).check(matches(withText("Engineer")));


    }

    @Test
    public void checkSections(){
        onView(withId(R.id.section4)).perform(typeText("Engineer"));
        onView(withId(R.id.section4)).check(matches(withText("Engineer")));
        onView(withId(R.id.section3)).perform(typeText("Engineer"));
        onView(withId(R.id.section3)).check(matches(withText("Engineer")));
        onView(withId(R.id.section2)).perform(typeText("Engineer"));
        onView(withId(R.id.section2)).check(matches(withText("Engineer")));
        onView(withId(R.id.firstSection)).perform(typeText("Engineer"));
        onView(withId(R.id.firstSection)).check(matches(withText("Engineer")));
    }

    @Test
    public void checkOnClick(){
        onView(withId(R.id.frequently)).perform(click());
        onView(withId(R.id.code5)).check(matches(isDisplayed()));
    }

    @Test
    public void checkSubmitNull(){
        onView(withId(R.id.submitClasses)).perform(click());
        onView(withId(R.id.code1)).check(matches(isDisplayed()));
    }

    @Test
    public void checkSubmit(){
        onView(withId(R.id.firstSection)).perform(typeText("Engineer"));
        onView(withId(R.id.code1)).perform(typeText("Engineer"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.submitClasses)).perform(click());
        onView(withId(R.id.map)).check(matches(isDisplayed()));
    }









}
