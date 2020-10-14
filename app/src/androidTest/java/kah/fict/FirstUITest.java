package kah.fict;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.*;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class FirstUITest {
    @Rule
    public final ActivityTestRule<Homepage>homepageActivityTestRule = new ActivityTestRule<>(Homepage.class);
    @Test
    public void checkStartButton() throws Exception {
        onView(withId(R.id.profileButton)).check(matches(allOf(
                isClickable(),
                withText(R.string.let_s_go)

        )));
    }
    @Test
    public void chekRedirectAfterStart()  {
        onView(withId(R.id.profileButton)).perform(click());

    }
}
