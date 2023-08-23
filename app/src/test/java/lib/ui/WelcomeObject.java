package lib.ui;


import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;

public class WelcomeObject extends MainPageObject {
    private static final String
            STEP_LINK_MORE_LINK = "id:Learn more about Wikipedia",
            STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore",
            STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "id:Add or edit preferred languages",
            STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "id:Learn more about data collected",
            NEXT_LINK = "id:Next",
            GET_STARTED_BUTTON = "id:Get started",
            SKIP = "id: Skip";

    public WelcomeObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreLink() {
        waitForElementPresentById(
                STEP_LINK_MORE_LINK,
                "Cannot find element",
                15);
    }

    public void waitForNewWayToExploreText() {
        waitForElementPresentById(
                STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find element",
                15);
    }


    public void waitForAddOrEditPreferredLangText() {
        waitForElementPresentById(
                STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK,
                "Cannot find element",
                15);
    }

    public void waitForLearnMoreAboutDataCollectedText() {
        waitForElementPresentById(
                STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK,
                "Cannot find element",
                15);
    }

    public void clickGetStartedButton() {
        waitForElementAndClick(
                NEXT_LINK,
                "Cannot find element",
                15);
    }

    public void clickNextButton() {
        waitForElementAndClick(
                GET_STARTED_BUTTON,
                "Cannot find element",
                15);
    }

    public void clickSkip() {
        waitForElementAndClick(
                SKIP,
                "Cannot find element",
                15
        );
    }
}
