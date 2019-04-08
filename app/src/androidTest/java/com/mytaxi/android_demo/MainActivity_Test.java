package com.mytaxi.android_demo;

import android.graphics.Point;
import android.os.RemoteException;

import com.mytaxi.android_demo.activities.DriverProfileActivity;
import com.mytaxi.android_demo.activities.MainActivity;

import org.hamcrest.Matchers;
import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Type;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ReplaceTextAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import static android.service.autofill.Validators.not;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.google.android.material.internal.ContextUtils.getActivity;
import static com.mytaxi.android_demo.R.id.searchContainer;
import static com.mytaxi.android_demo.activities.FinalTest.childAtPosition;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)

public class MainActivity_Test {

    public static AuthenticationActivity_Test authTest = new AuthenticationActivity_Test();

    @Rule
    public ActivityTestRule<MainActivity> activityRule_MainActivity
            = new ActivityTestRule<>(MainActivity.class);


    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    @Before
    public void init(){
        activityRule_MainActivity.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }


    @Test
    public void searchDriver() throws InterruptedException {

        String driverSearchKey = "sa";
        String drivername = "Sarah Scott";

        onView(withId(R.id.textSearch))
                .perform(clearText()
                        , typeText(driverSearchKey));

        onData(anything()).inAdapterView(withText(is(drivername))).atPosition(1).perform(click());
        //onView(allOf(withText("Driver Profile"))).check(matches(isDisplayed()));




       // onView(withId(R.id.searchContainer)).perform(ViewMatchers.withSpinnerText(""));


        Thread.sleep(10000);

    }


}
