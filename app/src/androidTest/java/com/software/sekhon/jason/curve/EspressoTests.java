package com.software.sekhon.jason.curve;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void TestDescription() {
        onView(withId(2)).perform(click());
        onView(withId(R.id.desc_action_back)).perform(click(), closeSoftKeyboard());
    }

    @Test
    public void TestSearchByName() {
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.FirstName)).perform(typeText("Steven"), closeSoftKeyboard());
        onView(withId(R.id.LastName)).perform(typeText("Stamkos"), closeSoftKeyboard());
        onView(withId(R.id.SearchButton)).perform(click());
    }

    @Test
    public void TestSearchByPosition() {
        onView(withId(R.id.action_search)).perform(click());
        onView(withId(R.id.Positions)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("C"))).perform(click());
        onView(withId(R.id.SearchButton)).perform(click());
    }
}
