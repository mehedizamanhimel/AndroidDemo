package com.mytaxi.android_demo;


import com.mytaxi.android_demo.activities.DriverProfileActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class DriverProfileActivity_Test {

@Rule
public ActivityTestRule<DriverProfileActivity> activityRule_DriverPage
        = new ActivityTestRule<>(DriverProfileActivity.class);



    @Before
    public void init(){
        activityRule_DriverPage.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }


    @Test
    public void callingDriver(){
        onView(withId(R.id.fab))
                .check(matches(isDisplayed()));
        onView(withId(R.id.fab))
                .perform(click());
    }

    @After
    public void afterTest(){

    }

}
