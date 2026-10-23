package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private fun goToRaces() {
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()
    }

    private fun goToDrivers() {
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()
    }

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        goToRaces()

        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun home_to_drivers() {
        goToDrivers()

        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()
    }

    @Test
    fun add_driver_is_displayed() {
        goToDrivers()

        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Max Verstappen")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertExists()
    }

    @Test
    fun clear_drivers_removes_them() {
        goToDrivers()

        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Lewis Hamilton")

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertDoesNotExist()
    }

    @Test
    fun drivers_back_button_returns_home() {
        goToDrivers()

        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}