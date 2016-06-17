package com.udacity.gradle.builditbigger;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTestFree {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.instructions_text_view), withText(R.string.instructions),
                        withParent(allOf(withId(R.id.fragment),
                                withParent(allOf(withId(android.R.id.content),
                                        withParent(withId(R.id.decor_content_parent)))))),
                        isDisplayed()));
        textView.check(matches(withText(R.string.instructions)));


        ViewInteraction button = onView(
                allOf(withId(R.id.joke_button), withText(R.string.button_text),
                        withParent(allOf(withId(R.id.fragment),
                                withParent(allOf(withId(android.R.id.content),
                                        withParent(withId(R.id.decor_content_parent)))))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.joke_button), withText(R.string.button_text),
                        withParent(allOf(withId(R.id.fragment),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction imageButton = onView(
                allOf(withContentDescription("Interstitial close button"), isDisplayed()));
        imageButton.perform(click());

        ViewInteraction jokeTextView = onView(
                allOf(withId(R.id.joke_textview),
                        withParent(allOf(withId(R.id.fragment),
                                withParent(allOf(withId(android.R.id.content),
                                        withParent(withId(R.id.decor_content_parent)))))),
                        isDisplayed()));
        jokeTextView.check(matches(isDisplayed()));

    }
}
