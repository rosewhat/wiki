package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUIPageObject;

public class IosPageObjectNavigationPageObject extends NavigationUIPageObject {
    static {
        XPATH_FIND_NAVIGATION_LIST = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }

    public IosPageObjectNavigationPageObject(AppiumDriver driver) {
        super(driver);
    }
}
