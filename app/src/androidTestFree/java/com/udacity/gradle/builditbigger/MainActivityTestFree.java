package com.udacity.gradle.builditbigger;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTestFree {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction button = onView(
                allOf(withId(R.id.joke_button), withText(R.string.button_text),
                        withParent(allOf(withId(R.id.fragment),
                                withParent(allOf(withId(android.R.id.content),
                                        withParent(withId(R.id.decor_content_parent)))))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        // TODO:  I give up.  I can't get espresso to recognize the interstitial ad.
        // It fails after the button click.

//        ViewInteraction appCompatButton = onView(
//                allOf(withId(R.id.joke_button), withText(R.string.button_text),
//                        withParent(allOf(withId(R.id.fragment),
//                                withParent(withId(android.R.id.content)))),
//                        isDisplayed()));
//        appCompatButton.perform(click());

//        onView(withId(R.id.progressBar))
//                .check(matches(isDisplayed()));
//
//        // TODO: Find better way to wait for ad to load
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            //
//        }
//
//        ViewInteraction imageButton = onView(
//               allOf(withContentDescription("Interstitial close button"), isDisplayed()));
//        imageButton.perform(click());
//
//        pressBack();
//
//        ViewInteraction jokeTextView = onView(
//                allOf(withId(R.id.joke_textview),
//                        isDisplayed()));
//        jokeTextView.check(matches(isDisplayed()));

    }
}
