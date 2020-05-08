package com.example.nytimes

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.nytimes.presentation.view.DetailsActivity
import junit.framework.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


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
