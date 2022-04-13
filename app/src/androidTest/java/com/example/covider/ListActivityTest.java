package com.example.covider;


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
public class ListActivityTest {
    @Rule
    public ActivityScenarioRule<ListActivity> activityScenarioRule = new ActivityScenarioRule<>(ListActivity.class);

    @Test
    public void checkValues(){
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.map)).check(matches(isDisplayed()));
    }

}
