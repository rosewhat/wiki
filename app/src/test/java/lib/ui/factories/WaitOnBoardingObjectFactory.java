package lib.ui.factories;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import lib.MyPlatform;
import lib.ui.WaitOnboardingPageObject;
import lib.ui.android.AndroidWaitOnBoardingPageObject;
import lib.ui.ios.IosWaitOnBoardingPageObject;

public class WaitOnBoardingObjectFactory {
    public static WaitOnboardingPageObject get(RemoteWebDriver appiumDriver) {
        if (MyPlatform.getInstance().isAndroid()) {
            return new AndroidWaitOnBoardingPageObject(appiumDriver);
        } else {
            return new IosWaitOnBoardingPageObject(appiumDriver);
        }
    }
}
