package com.mytaxi.android_demo;



import com.mytaxi.android_demo.activities.AuthenticationActivity;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;



import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

//@RunWith(AndroidJUnit4ClassRunner.class)
@RunWith(AndroidJUnit4.class)

public class AuthenticationActivity_Test {


    private static String wrongUsername = "sdffdsf@dd";
    private static String wrongPassword = "123!@#";
    private static String correctUsername = "crazydog335";
    private static String correctPassword = "venture";
    private static String failedMessage = "Login failed";
    private static String successfulLoginMessage = "mytaxi demo";


    @Rule
    public ActivityTestRule<AuthenticationActivity> mActivityTestRule = new ActivityTestRule<>(AuthenticationActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");


    @Before
    public void beforeTest(){

    }

    @Test
    public void LoginTest_Blank() {
        onView(withId(R.id.edt_username))
                .perform(typeText("")
                , closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText("")
                , closeSoftKeyboard());
        onView(withId(R.id.btn_login))
                .perform(click());

        onView(withText(failedMessage))
                .check(matches(isDisplayed()));

    }


    @Test
    public void LoginTest_Negative_WorngUsername_WrongPassword() {

        onView(withId(R.id.edt_username))
                .perform(typeText(wrongUsername)
                , closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(wrongPassword)
                , closeSoftKeyboard());
        onView(withId(R.id.btn_login))
                .perform(click());

        onView(withText(failedMessage))
                .check(matches(isDisplayed()));
    }

    @Test
    public void LoginTest_Negative_RightUserName_WrongPassword() {

        onView(withId(R.id.edt_username))
                .perform(typeText(correctUsername)
                , closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(wrongPassword)
                ,closeSoftKeyboard());
        onView(withId(R.id.btn_login))
                .perform(click());

        onView(withText(failedMessage))
                .check(matches(isDisplayed()));
    }


    @Test
    public void LoginTest_Positive() {



        onView(withId(R.id.edt_username))
                .perform(typeText(correctUsername)
                        , closeSoftKeyboard());
        onView(withId(R.id.edt_password))
                .perform(typeText(correctPassword)
                        , closeSoftKeyboard());
        onView(withId(R.id.btn_login))
                .perform(click());
        onView(withText(successfulLoginMessage))
                .check(matches(isDisplayed()));


    }


    @After
    public void AfterTest(){

    }

}


