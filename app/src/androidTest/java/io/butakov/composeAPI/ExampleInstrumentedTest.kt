package io.butakov.composeAPI

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun app_launches() {
        composeTestRule.onNodeWithText("Hello, Welcome to App!").assertExists()
    }
    @Test
    fun isDisplayed_textCard0() {
        composeTestRule.onNodeWithText("Check out our App every week for exciting offers.").assertExists()
    }
    @Test
    fun areAllImagesClickable(){
        composeTestRule.onAllNodesWithText("Tap").assertAll(hasClickAction())
    }


    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("io.butakov.composeAPI", appContext.applicationContext)
    }
}