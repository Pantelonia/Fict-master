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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DailyPageTest {
    @Rule
    public final ActivityTestRule<DailyPage> dailyPageActivityTestRule = new ActivityTestRule<>(DailyPage.class);

    @Test
    public void checkRightPage() throws Exception {
        onView(withId(R.id.textCalories)).check(matches(
                withText(R.string.calories)
        ));
    }

    @Test
    public void checkCaloriesTable() {
        onView(withId(R.id.valueGoal));
        onView(withId(R.id.valueFood));
        onView(withId(R.id.valueRemaining));
    }

    @Test
    public void checkNutritionTitle() {
        onView(withId(R.id.textNutrition)).check(matches(withText(R.string.nutrition)));
        onView(withId(R.id.textWeight));
        onView(withId(R.id.textProtein));
        onView(withId(R.id.textFat));
        onView(withId(R.id.textCarbs));
    }

    @Test
    public void checkFoodList() {
        onView(withId(R.id.foodList));
        onView(withId(R.id.textMeals)).check(matches(withText(R.string.food)));
    }

    @Test
    public void checkNavigation() {
        onView(withId(R.id.navigation));
    }

    @Test
    public void checkRederectOnCulculator() {
        onView(withId(R.id.nutrition_calculator)).check(matches(
                isClickable()
        ));
        onView(withId(R.id.nutrition_calculator)).perform(click());

    }

    @Test
    public void checkRederectOnAddDish() {
        onView(withId(R.id.add_food)).check(matches(
                isClickable()
        ));
        onView(withId(R.id.add_food)).perform(click());

    }

    @Test
    public void checkRederectOnHistoryr() {
        onView(withId(R.id.history)).check(matches(
                isClickable()
        ));
        onView(withId(R.id.history)).perform(click());

    }


}
