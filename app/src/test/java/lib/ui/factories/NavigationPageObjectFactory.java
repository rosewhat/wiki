package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.MyPlatform;
import lib.ui.NavigationUIPageObject;
import lib.ui.android.AndroidPageObjectNavigationPageObject;
import lib.ui.ios.IosPageObjectNavigationPageObject;

public class NavigationPageObjectFactory {
    public static NavigationUIPageObject get(AppiumDriver appiumDriver) {
        if (MyPlatform.getInstance().isAndroid()) {
            return new AndroidPageObjectNavigationPageObject(appiumDriver);
        } else {
            return new IosPageObjectNavigationPageObject(appiumDriver);
        }
    }
}
