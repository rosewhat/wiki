package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUIPageObject;

public class AndroidPageObjectNavigationPageObject extends NavigationUIPageObject {
    static {
        XPATH_FIND_NAVIGATION_LIST = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }
    public AndroidPageObjectNavigationPageObject(AppiumDriver driver) {
        super(driver);
    }

}
