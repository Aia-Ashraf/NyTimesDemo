package com.example.nytimes

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.example.nytimes.presentation.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule;
import com.example.nytimes.presentation.view.DetailsActivity
import junit.framework.Assert.assertTrue
import org.junit.Before


@RunWith(AndroidJUnit4::class)
class DetailsActivityViewUnitTesting {
    @get:Rule
    val detailsActivityRule = ActivityTestRule(DetailsActivity::class.java)

    @Test
    fun backPress() {
        Espresso.pressBackUnconditionally()
        assertTrue(detailsActivityRule.activity.isDestroyed)
    }

    @Test
    fun appBarTitle() {
        onView(withText("NyTimes")).check(matches(isDisplayed()))
    }
}
