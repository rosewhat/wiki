package lib.ui;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;

import static lib.ui.DefaultParams.*;


public class NavigationUI extends MainPageObject {
    private static String XPATH_FIND_NAVIGATION_LIST = "//android.widget.FrameLayout[@content-desc='My lists']";


    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists() {
        // Перейти по 2 вкладке в navigationBar
        waitForElementAndClick(
                By.xpath(XPATH_FIND_NAVIGATION_LIST),
                getDefaultErrorMessageFindElements(" в Navigation 2 вкладку"),
                getDefaultWaitForElement
        );
    }
}