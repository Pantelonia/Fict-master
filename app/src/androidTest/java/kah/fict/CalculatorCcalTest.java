package kah.fict;

import android.content.Context;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
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
public class CalculatorCcalTest {
    @Rule
    public final ActivityTestRule<MacrosCalculator>macrosCalculatorActivityTestRule = new ActivityTestRule<>(MacrosCalculator.class);
    @Test
    public void checkStartButton() throws Exception {
        onView(withId(R.id.editAge)).perform(typeText("21"));
        closeSoftKeyboard();
        onView(withId(R.id.editHeight)).perform(typeText("185"));
        closeSoftKeyboard();
        onView(withId(R.id.editWeight)).perform(typeText("185"));
        closeSoftKeyboard();

        onView(withId(R.id.genderSpinner)).perform(click());
        onView(allOf(withText("Male"))).perform(click());
        onView(withId(R.id.activeSpinner)).perform(click());
        onView(allOf(withText("Lightly Active"))).perform(click());
        onView(withId(R.id.goalSpinner)).perform(click());
        onView(allOf(withText("Maintain Weight"))).perform(click());

        onView(withId(R.id.calculateButton)).perform(click());
        onView(allOf(withText("Save"))).perform(click());
        
        onView(withId(R.id.valueGoal)).check(matches(withText("2606")));
        SystemClock.sleep(2000);

    }
}
