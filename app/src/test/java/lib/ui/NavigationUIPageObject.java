package lib.ui;

import io.appium.java_client.AppiumDriver;

import static lib.ui.DefaultParams.*;


abstract public class NavigationUIPageObject extends MainPageObject {
    protected static String XPATH_FIND_NAVIGATION_LIST;


    public NavigationUIPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists() {
        // Перейти по 2 вкладке в navigationBar
        waitForElementAndClick(
                XPATH_FIND_NAVIGATION_LIST,
                getDefaultErrorMessageFindElements(" в Navigation 2 вкладку"),
                getDefaultWaitForElement
        );
    }
}