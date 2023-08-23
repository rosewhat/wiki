package lib.ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import lib.MyPlatform;
import lib.ui.NavigationUIPageObject;
import lib.ui.android.AndroidPageObjectNavigationPageObject;
import lib.ui.ios.IosPageObjectNavigationPageObject;

public class NavigationPageObjectFactory {
    public static NavigationUIPageObject get(RemoteWebDriver appiumDriver) {
        if (MyPlatform.getInstance().isAndroid()) {
            return new AndroidPageObjectNavigationPageObject(appiumDriver);
        } else {
            return new IosPageObjectNavigationPageObject(appiumDriver);
        }
    }
}
